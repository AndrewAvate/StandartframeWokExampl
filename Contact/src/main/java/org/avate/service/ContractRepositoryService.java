package org.avate.service;

import java.util.List;

import org.avate.domain.Contact;
import org.avate.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service("contactService")
@Repository
@Transactional
public class ContractRepositoryService implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}

	@Transactional(readOnly=true)
	public Contact findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact save(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

}
