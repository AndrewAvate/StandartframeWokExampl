package org.avate.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional.TxType;

import org.avate.domain.Contact;
import org.avate.domain.ContactTelDetail;
import org.springframework.stereotype.Repository;

@Repository("contactServiceImpl")
public class ContactServiceImpl {

	private static final String LIST_SELECT_QUERY = "SELECT DISTINCT c FROM Contact c LEFT JOIN FETCH c.contactTelDetails d LEFT JOIN FETCH c.hobbies h ";
	private static final String SELECT_BY_ID_QUERY = "SELECT DISTINCT c FROM Contact c LEFT JOIN FETCH c.contactTelDetails d LEFT JOIN FETCH c.hobbies h WHERE c.id=:id";
	
	private static final String DETAILS_LIST_SELECT_QUERY = "SELECT c FROM ContactTelDetail c";

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Contact> selectAll() {
		Query query = entityManager.createQuery(LIST_SELECT_QUERY);
		@SuppressWarnings("unchecked")
		List<Contact> persons = (List<Contact>) query.getResultList();
		return persons;
	}

	@javax.transaction.Transactional(value = TxType.REQUIRED)
	public Contact findById(Long id) {
		Query query = entityManager.createQuery(SELECT_BY_ID_QUERY);
		query.setParameter("id", id);	
		return (Contact) query.getSingleResult();
	}
	
	
	public List<ContactTelDetail> selectAllDetails() {
		Query query = entityManager.createQuery(DETAILS_LIST_SELECT_QUERY);
		@SuppressWarnings("unchecked")
		List<ContactTelDetail> details = (List<ContactTelDetail>) query.getResultList();
		return details;
	}

}
