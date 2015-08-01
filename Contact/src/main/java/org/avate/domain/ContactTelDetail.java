package org.avate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "contact_tel_detail")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class ContactTelDetail implements Serializable {
	private static final long serialVersionUID = 6717395618335666507L;
	
	private Long id;
	private int version;
	private String telType;
	private String telNumber;
	private Contact contact;

	public ContactTelDetail() {
	}
	
	public ContactTelDetail(String telType, String telNumber) {
		this.telNumber = telNumber;
		this.telType = telType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "TEL_TYPE")
	public String getTelType() {
		return telType;
	}

	public void setTelType(String telType) {
		this.telType = telType;
	}

	@Column(name = "TEL_NUMBER")
	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	@ManyToOne
	//Ø@JsonIgnore
	@JsonBackReference
//	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
//	@JsonIdentityReference(alwaysAsId=true)
	@JoinColumn(name="CONTACT_ID")
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
	public String toString() {
		return "Details - Id: " + id + ", Tel type: " + telType
				+ ", Tel number: " + telNumber;
	}
	
	

}
