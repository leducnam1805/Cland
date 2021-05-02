package edu.vinaenter.controllers.auth;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.User;

@Controller
@RequestMapping(URLConstant.URL_AUTH)
public class AuthController {

	@GetMapping(URLConstant.URL_AUTH_LOGIN)
	public String login(@RequestParam(value="error",required = false) String error,
			ModelMap modelMap) {
		
		if (error != null) {
			modelMap.addAttribute("error", "Đăng nhập thất bại");
	    }

		return "auth.login";
	}
//	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
//			@RequestParam(value = "logout", required = false) String logout , HttpServletRequest request) {

	@PostMapping(URLConstant.URL_AUTH_LOGIN)
	public String login1(@Valid @ModelAttribute("us") User user,
			BindingResult result) {
		if(result.hasErrors()) {
			return "auth.login";
		}
		return "";
	}

}
