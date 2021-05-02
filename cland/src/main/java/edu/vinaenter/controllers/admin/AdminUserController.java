package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Roles;
import edu.vinaenter.models.User;
import edu.vinaenter.service.RolesService;
import edu.vinaenter.service.UserService;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_USER)
public class AdminUserController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RolesService rolesService;
	
	
	@GetMapping(value={URLConstant.INDEX,URLConstant.INDEX_PAGE},produces = MediaType.TEXT_PLAIN_VALUE)
	public String index(ModelMap modelMap,
			@PathVariable(required = false) Integer page,
			@RequestParam(value="q",required=false) String search) {
		List<User> userList = null;
		if (page == null) {
			page = 1;
		}
		int offset = PageUtil.getOffset(page);
		if(search != null) {
			userList = userService.findByFullname(search,offset,GlobalConstant.TOTAL_ROW);
			modelMap.addAttribute("totalPage", PageUtil.getTotalpage(userService.totalRowByFullname(search)));
		}else {
			userList = userService.getAll(offset,GlobalConstant.TOTAL_ROW);
			modelMap.addAttribute("totalPage", PageUtil.getTotalpage(userService.totalRow()));
		}
		modelMap.addAttribute("search", search);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("userList", userList);
		return "admin.user.index";
	}
	
	@GetMapping(URLConstant.ADD)
	public String add(ModelMap modelMap) {
		List<Roles> roleList = rolesService.getAll();
		modelMap.addAttribute("roleList", roleList);
		return "admin.user.add";
	}
	
	@PostMapping(URLConstant.ADD)
	public String add(@Valid @ModelAttribute("us") User user,
			BindingResult result,
			RedirectAttributes ra,
			@RequestParam("rid") int rid,
			ModelMap modelMap) {
		List<Roles> roleList = rolesService.getAll();
		modelMap.addAttribute("roleList", roleList);
		
		if(result.hasErrors()){
			return "admin.user.add";
		}
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(new Roles(rid, null));
		if(userService.save(user)> 0) {
			ra.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}
		return "admin.user.add";
	}
	
	@GetMapping(URLConstant.FIND_BY_ID)
	public String edit(@PathVariable int id,ModelMap modelMap) {
		List<Roles> roleList = rolesService.getAll();
		modelMap.addAttribute("roleList", roleList);
		
		User user = userService.findById(id);
		modelMap.addAttribute("user", user);
		return "admin.user.edit";
	}

	@PostMapping(URLConstant.UPDATE)
	public String edit(@Valid @ModelAttribute("user") User user,
			BindingResult result,
			RedirectAttributes ra,
			@RequestParam("rid") int rid) {
		User oldUser = userService.findById(user.getId());
		if("".equals(user.getPassword())) {
			user.setPassword(oldUser.getPassword());
		}else {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		}
		
		if (result.hasErrors()) {
			return "admin.user.edit";
		}
		user.setRole(new Roles(rid, null));
		if(userService.update(user)> 0) {
			ra.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}
			
		return "admin.user.edit";
	}
	
	@GetMapping(URLConstant.DELETE)
	public String del(@PathVariable int id,RedirectAttributes ra) {
		if(userService.del(id)> 0) {
			ra.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}
		return "admin.user.index";
	}

}
