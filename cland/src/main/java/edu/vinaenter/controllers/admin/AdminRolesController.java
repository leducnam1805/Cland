package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Roles;
import edu.vinaenter.service.RolesService;

@Controller
@RequestMapping(URLConstant.URL_ROLE)
public class AdminRolesController {

	@Resource
	protected MessageSource messageSource;
	
	@Autowired
	private RolesService rolesService;
	
	@GetMapping(URLConstant.INDEX)
	public String index(ModelMap modelMap) {
		List<Roles> rolesList = rolesService.getAll();
		modelMap.addAttribute("rolesList", rolesList);
		return "admin.roles.index";
	}
	
	@GetMapping(URLConstant.ADD)
	public String add() {
		return "admin.roles.add";
	}
	
	@PostMapping(URLConstant.ADD)
	public String add(@Valid @ModelAttribute("ro") Roles role,
			BindingResult result,
			RedirectAttributes ra) {
		if(result.hasErrors()) {
			return "admin.roles.add";
		}
		
		if(rolesService.findOne(role) != null) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.errorRoleNamesake", null, Locale.getDefault()));
			return "redirect:/admin/role/add";
		}else {
			if(rolesService.save(role) > 0) {
				ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
				return "redirect:/admin/role/index";
			}
		}
		
		return "admin.roles.add";
	}
	
	@GetMapping(URLConstant.FIND_BY_ID)
	public String findById(@PathVariable int id,ModelMap modelMap) {
		Roles roles = rolesService.findById(id);
		modelMap.addAttribute("role", roles);
		return "admin.roles.edit";
	}
	
	@PostMapping(URLConstant.UPDATE)
	public String update(@Valid @ModelAttribute("ro") Roles role,
			BindingResult result,
			RedirectAttributes ra){
		if(result.hasErrors()) {
			return "admin.roles.edit";
		}
		if(rolesService.update(role) > 0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/role/index";
		}
		return "admin.roles.index";
	}
}
