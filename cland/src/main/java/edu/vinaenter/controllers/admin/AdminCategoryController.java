package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Category;
import edu.vinaenter.service.CatService;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_CAT)
public class AdminCategoryController {

	@Resource
	protected MessageSource messageSource;

	@Autowired
	private CatService catService;

	@GetMapping(URLConstant.INDEX)
	public String cat(Model model) {
		List<Category> catList = catService.getAll();
		model.addAttribute("catList", catList);
		return "admin.cat.index";
	}

	@GetMapping(URLConstant.DELETE)
	public String del(@PathVariable int id, RedirectAttributes ra) {
		if (catService.del(id) > 0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		} else {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.error", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
	}

	@GetMapping(URLConstant.ADD)
	public String add() {
		return "admin.cat.add";
	}

	@PostMapping(URLConstant.ADD)
	public String add(@Valid @ModelAttribute("cat") Category category, BindingResult result, RedirectAttributes ra) {
		if (result.hasErrors()) {
			return "admin.cat.add";
		}
		if (catService.save(category) > 0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
		return "admin.cat.add";
	}

	@GetMapping(URLConstant.FIND_BY_ID)
	public String edit(@PathVariable int id, ModelMap modelMap) {
		Category category = catService.findById(id);
		modelMap.addAttribute("category", category);
		return "admin.cat.edit";
	}

	@PostMapping(URLConstant.UPDATE)
	public String edit(@Valid @ModelAttribute("cat") Category category, BindingResult result, RedirectAttributes ra) {
		if (result.hasErrors()) {
			return "admin.cat.edit";
		}
		if (catService.update(category) > 0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
		return "admin.cat.edit";
	}
}
