package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Roles;
import edu.vinaenter.models.User;
import edu.vinaenter.service.RolesService;
import edu.vinaenter.service.UserService;

@Controller
public class AdminProfileController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private RolesService rolesService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(URLConstant.URL_PROFILE)
	public String profile(@PathVariable(required = false) Integer id,
			HttpSession session) {
		User user = userService.findById(id);
		session.setAttribute("user", user);
		return "profile";
	}
	@GetMapping(URLConstant.URL_PROFILE_UPDATE)
	public String profile(@PathVariable(required = false) Integer id,
			ModelMap modelMap) {
		List<Roles> roleList = rolesService.getAll();
		modelMap.addAttribute("roleList", roleList);
		
		User user = userService.findById(id);
		modelMap.addAttribute("user", user);
		return "profile.edit";
	}
	
	@PostMapping(URLConstant.URL_PROFILE_UPDATE)
	public String profile(@Valid @ModelAttribute("us") User user,
			BindingResult result,
			RedirectAttributes ra,
			@RequestParam("rid") int rid) {
		
		User oldUser = userService.findById(user.getId());
		if("".equals(user.getPassword())) {
			user.setPassword(oldUser.getPassword());
		}else {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		}
		
		user.setRole(new Roles(rid, null));
		if(userService.updateProfile(user) > 0) {
			ra.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/profile/"+user.getId();
		}
		
		return "profile.edit";
	}
	
	
	
}
