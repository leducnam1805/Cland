package edu.vinaenter.controllers.cland;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import edu.vinaenter.models.Category;
import edu.vinaenter.models.Land;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandService;

@Controller
public class ClandSingleController {

	@Autowired
	private LandService landService;
	
	@Autowired
	private CatService catService;
	
	@GetMapping("/single")
	public String single(ModelMap modelMap) {
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
		return "cland.single";
	}
	
}
