package org.avate.controllers.mvc;


import org.avate.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc")
public class MvcController {


	@Autowired
	private ContactServiceImpl dao;
	
	
	@RequestMapping(value="/helloWorld", method = RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("name", dao.selectAll().get(0));
		return "helloWorld";
	}
	
	@RequestMapping(value="/protection", method = RequestMethod.GET)
	public String protection(Model model) {
		model.addAttribute("name", "This is protected page");
		return "helloWorld";
	}

	
	
	//getters & setters
	public ContactServiceImpl getDao() {
		return dao;
	}

	public void setDao(ContactServiceImpl dao) {
		this.dao = dao;
	}

	


}
