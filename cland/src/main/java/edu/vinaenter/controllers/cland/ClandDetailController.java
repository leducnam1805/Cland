package edu.vinaenter.controllers.cland;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Land;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandService;

@Controller
public class ClandDetailController {
	
	@Autowired
	private LandService landService;
	
	@Autowired
	private CatService catService;

	@GetMapping(URLConstant.DETAIL)
	public String index(ModelMap modelMap,@PathVariable(required=false) Integer id) {
		//menu header
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		
		//increase views
		landService.increaseViews(id);
		
		Land land = landService.findById(id);
		modelMap.addAttribute("land", land);
		
		int cid = land.getCat().getCid();
		int lid = land.getLid();
		List<Land> landList = landService.findLand(cid,lid);
		modelMap.addAttribute("landList", landList);
		
		//right bar
		List<Land> landListGroup = landService.groupByCid();
		modelMap.addAttribute("landListGroup", landListGroup);
		
		List<Land> CountViewList = landService.getCountViews();
		modelMap.addAttribute("CountViewList", CountViewList);
		
		List<Land> countViewsCatList = landService.getCountViewCat();
		modelMap.addAttribute("countViewsCatList", countViewsCatList);
		return "cland.detail";
	}
	
}
