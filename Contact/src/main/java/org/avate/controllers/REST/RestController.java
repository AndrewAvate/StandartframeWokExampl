package org.avate.controllers.REST;

import java.util.List;

import org.avate.domain.Contact;
import org.avate.domain.ContactTelDetail;
import org.avate.service.ContactServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rs")
public class RestController {
	
	public static final String CONTACT_LIST = "contacts";
	public static final String CONTACT_BY_ID = "contact";
	public static final String DETAIL_LIST = "details";

	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	
	@Autowired
	private ContactServiceImpl dao;

	@RequestMapping(value = CONTACT_LIST, method = RequestMethod.GET)
	public @ResponseBody List<Contact> getContactLsit() {
		logger.info("get all contacts");
		return dao.selectAll();
	}

	@RequestMapping(value = CONTACT_BY_ID, method = RequestMethod.GET)
	public @ResponseBody Contact getContactById(Long id) {
		return dao.findById(id);
	}
	
	@RequestMapping(value = DETAIL_LIST, method = RequestMethod.GET)
	public @ResponseBody List<ContactTelDetail> getContactTelDetailLsit() {
		logger.info("get all details");
		return dao.selectAllDetails();
	}


	
	
	public ContactServiceImpl getDao() {
		return dao;
	}

	public void setDao(ContactServiceImpl dao) {
		this.dao = dao;
	}
}
