package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.models.Land;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandService;
import edu.vinaenter.util.FileUtil;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_LAND)
public class AdminLandController {

	@Resource
	protected MessageSource messageSource;
	@Autowired
	private CatService catService;

	@Autowired
	private LandService landService;

	// index/2
	// ofset = (page-1) * row_cont;
	//
	@GetMapping({URLConstant.INDEX, URLConstant.INDEX_PAGE})
	public String index(ModelMap modelMap,
			@PathVariable(required = false) Integer page,
			@RequestParam(value="q",required=false) String search) {
		List<Land> landList = null;
		if (page == null) {
			page = 1;
		}
		int offset = PageUtil.getOffset(page);
		if(search != null) {
			landList = landService.findBylname(search,offset,GlobalConstant.TOTAL_ROW);
			modelMap.addAttribute("totalPage", PageUtil.getTotalpage(landService.totalRowByLname(search)));
		}else {
			landList = landService.getAll(offset, GlobalConstant.TOTAL_ROW);
			modelMap.addAttribute("totalPage", PageUtil.getTotalpage(landService.totalRow()));
		}
		modelMap.addAttribute("search", search);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("landList", landList);
		return "admin.land.index";
	}

	@GetMapping(URLConstant.FIND_BY_ID)
	public String edit(@PathVariable int id,ModelMap modelMap) {
		Land land = landService.findById(id);
		modelMap.addAttribute("land", land);
		
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		return "admin.land.edit";
	}
	
	@GetMapping(URLConstant.DELETE)
	public String del(@PathVariable int id,
			RedirectAttributes ra,
			HttpServletRequest request) {
		Land land = landService.findById(id);
		String filename = land.getPicture();
		System.out.println("filename: "+filename);
		if(landService.del(id) > 0) {
			FileUtil.delFile(filename, request);
			ra.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		}else {
			ra.addFlashAttribute("msg",messageSource.getMessage("msg.error", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		}
	}

	@GetMapping(URLConstant.ADD)
	public String add(ModelMap modelMap) {
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		return "admin.land.add";
	}

	@PostMapping(URLConstant.ADD)
	public String add(@Valid @ModelAttribute("ld") Land land,
			BindingResult result,
			@RequestParam("file") MultipartFile file,
			@RequestParam("cid") int cid,
			HttpServletRequest request,
			RedirectAttributes ra,
			ModelMap modelMap) {
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		if(result.hasErrors()) {
			return "admin.land.add";
		}
		
		land.setCat(new Category(cid, null));
		
		// hinh anh
		String fileName = FileUtil.upload(file, request);
		land.setPicture(fileName);

		if (landService.save(land) > 0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		}
		return "admin.land.add";
	}

	@PostMapping(URLConstant.UPDATE)
	public String edit(@ModelAttribute("ld") Land land,
			BindingResult result,
			@PathVariable int id,
			@RequestParam("file") MultipartFile file,
			@RequestParam("cid") int cid,
			HttpServletRequest request,
			RedirectAttributes ra,
			ModelMap modelMap) {
		List<Category> catList = catService.getAll();
		modelMap.addAttribute("catList", catList);
		if(result.hasErrors()) {
			return "admin.land.edit";
		}
		
		Land oldLand = landService.findById(id);
		
		// hinh anh
		String fileName = FileUtil.upload(file, request);
		land.setPicture(fileName);
		if("".equals(fileName)) {
			land.setPicture(oldLand.getPicture());
		}
		land.setCat(new Category(cid, null));
		land.setLid(id);
		
		if(landService.update(land)> 0) {
			ra.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		}
		return "admin.land.edit";
	}
}
