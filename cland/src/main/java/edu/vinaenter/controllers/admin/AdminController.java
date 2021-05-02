package edu.vinaenter.controllers.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.User;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandService;
import edu.vinaenter.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CatService catService;
	
	@Autowired
	private LandService landService;
	
	@Autowired
	private UserService userService;

	@GetMapping(URLConstant.INDEX)
	public String index(Authentication authentication,
			HttpSession session,
			ModelMap modelMap) {
		User user = userService.findByUsername(authentication.getName());
		session.setAttribute("user", user);
		
		int countCat = catService.getCountCat();
		int countLand = landService.getCountLand();
		int countUser = userService.getCountUser();
		modelMap.addAttribute("countCat", countCat);
		modelMap.addAttribute("countLand", countLand);
		modelMap.addAttribute("countUser", countUser);
		return "admin.index";
	}

}
