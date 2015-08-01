package org.avate;

import java.util.List;

import org.avate.domain.Contact;
import org.avate.service.ContactServiceImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	private static GenericXmlApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:root-context.xml");
		ctx.refresh();
		//ContactService testBean = ctx.getBean("contactService", ContactService.class);
		//System.out.println(testBean.findAll().get(0));
		ContactServiceImpl dao = ctx.getBean("contactServiceImpl", ContactServiceImpl.class);
		List<Contact> contacts = dao.selectAll();
		System.out.println(contacts.get(0));
		
	}

}
