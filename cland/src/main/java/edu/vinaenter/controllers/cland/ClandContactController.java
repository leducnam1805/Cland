package edu.vinaenter.controllers.cland;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Contact;
import edu.vinaenter.models.Land;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.ContactService;
import edu.vinaenter.service.LandService;

@Controller
@RequestMapping(URLConstant.CONTACT)
public class ClandContactController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private LandService landService;
	
	@Autowired
	private CatService catService;
	
	@GetMapping()
	public String contact(ModelMap modelMap) {
		//menu header
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		
		//right bar
		List<Land> landListGroup = landService.groupByCid();
		modelMap.addAttribute("landListGroup", landListGroup);
		
		List<Land> CountViewList = landService.getCountViews();
		modelMap.addAttribute("CountViewList", CountViewList);
		
		List<Land> countViewsCatList = landService.getCountViewCat();
		modelMap.addAttribute("countViewsCatList", countViewsCatList);
		return "cland.contact";
	}
	
	@PostMapping
	public String sendContact(@Valid @ModelAttribute("ct") Contact contact,
			BindingResult result,
			RedirectAttributes ra) {
		if(result.hasErrors()) {
			return "cland.contact";
		}
		if(contactService.save(contact) > 0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/contact";
		}
		
		return "cland.contact";
	}
	
}
