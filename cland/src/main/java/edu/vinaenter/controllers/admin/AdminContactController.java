package edu.vinaenter.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Contact;
import edu.vinaenter.service.ContactService;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_CONTACT)
public class AdminContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping({URLConstant.INDEX,URLConstant.INDEX_PAGE})
	public String index(ModelMap modelMap,
			@PathVariable(required = false) Integer page,
			@RequestParam(value="q",required=false) String search) {
		List<Contact> contactList = null;
		if (page == null) {
			page = 1;
		}
		int offset = PageUtil.getOffset(page);
		if(search != null) {
			contactList = contactService.findByFullname(search,offset,GlobalConstant.TOTAL_ROW);
			modelMap.addAttribute("totalPage", PageUtil.getTotalpage(contactService.totalRowByFullname(search)));
		}else {
			contactList = contactService.getAll(offset,GlobalConstant.TOTAL_ROW);
			modelMap.addAttribute("totalPage", PageUtil.getTotalpage(contactService.totalRow()));
		}
		modelMap.addAttribute("search", search);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("contactList", contactList);
		return "admin.contact.index";
	}

}
