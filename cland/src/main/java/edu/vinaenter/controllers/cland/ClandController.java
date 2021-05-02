package edu.vinaenter.controllers.cland;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Land;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandService;
import edu.vinaenter.util.PageUtil;

@Controller
public class ClandController {
	
	@Autowired
	private CatService catService;
	
	@Autowired
	private LandService landService;

	@GetMapping({URLConstant.INDEX,URLConstant.INDEX_PAGE})
	public String index(ModelMap modelMap, @PathVariable(required = false) Integer page) {
		//menu header
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		
		if (page == null) {
			page = 1;
		}
		int offset = PageUtil.getOffset(page);
		List<Land> landList = landService.getAll(offset, GlobalConstant.TOTAL_ROW);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("totalPage", PageUtil.getTotalpage(landService.totalRow()));
		modelMap.addAttribute("landList", landList);
		
		//right bar
		List<Land> landListGroup = landService.groupByCid();
		modelMap.addAttribute("landListGroup", landListGroup);
		
		List<Land> CountViewList = landService.getCountViews();
		modelMap.addAttribute("CountViewList", CountViewList);
		
		List<Land> countViewsCatList = landService.getCountViewCat();
		modelMap.addAttribute("countViewsCatList", countViewsCatList);
		
		return "cland.index";
	}
	/*
	 * @PostMapping({URLConstant.INDEX,URLConstant.INDEX_PAGE}) public String
	 * search(ModelMap modelMap,
	 * 
	 * @ModelAttribute("land") Land land,
	 * 
	 * @PathVariable(required = false) Integer page) { //menu header List<Category>
	 * catList = catService.getAll(); modelMap.addAttribute("catList", catList);
	 * 
	 * if (page == null) { page = 1; } int offset = PageUtil.getOffset(page);
	 * 
	 * String searchLName = land.getLname(); List<Land> searchLandList =
	 * landService.searchLName(offset, GlobalConstant.TOTAL_ROW,searchLName);
	 * modelMap.addAttribute("currentPage", page);
	 * modelMap.addAttribute("totalPage",
	 * PageUtil.getTotalpage(landService.totalRow()));
	 * modelMap.addAttribute("landList", searchLandList);
	 * 
	 * //right bar List<Land> landListGroup = landService.groupByCid();
	 * modelMap.addAttribute("landListGroup", landListGroup);
	 * 
	 * List<Land> CountViewList = landService.getCountViews();
	 * modelMap.addAttribute("CountViewList", CountViewList);
	 * 
	 * List<Land> countViewsCatList = landService.getCountViewCat();
	 * modelMap.addAttribute("countViewsCatList", countViewsCatList); return
	 * "cland.index"; }
	 */

}
