package edu.vinaenter.controllers.cland;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Land;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandService;

@Controller
public class ClandCatController {
	
	@Autowired
	private CatService catService;
	
	@Autowired
	private LandService landService;
	
	@GetMapping(URLConstant.CAT)
	public String cat(ModelMap modelMap,
			@ModelAttribute("land") Land land,
			@PathVariable(required=false) Integer id) {
		//menu header
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		
		List<Land> landList = landService.getLandCat(id);
		modelMap.addAttribute("land", landList);
		
		//right bar
		List<Land> landListGroup = landService.groupByCid();
		modelMap.addAttribute("landListGroup", landListGroup);
		
		List<Land> CountViewList = landService.getCountViews();
		modelMap.addAttribute("CountViewList", CountViewList);
		
		List<Land> countViewsCatList = landService.getCountViewCat();
		modelMap.addAttribute("countViewsCatList", countViewsCatList);
		return "cland.cat";
	}
	
}
