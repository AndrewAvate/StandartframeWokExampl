package org.avate.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "contact")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Contact implements Serializable {
	private static final long serialVersionUID = -8859952724057130630L;

	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String description;
	private byte[] photo;
	private Set<ContactTelDetail> contactTelDetails = new TreeSet<ContactTelDetail>();
	@OrderBy("hobbyId ASC")
	private Set<Hobby> hobbies = new TreeSet<Hobby>();

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

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// @JsonSerialize(using=DateSerializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic(fetch = FetchType.LAZY)
	@Lob
	@Column(name = "PHOTO")
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@JsonManagedReference 
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<ContactTelDetail> getContactTelDetails() {
		return contactTelDetails;
	}

	public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
		this.contactTelDetails = contactTelDetails;
	}

	@JsonManagedReference
	@ManyToMany
	@JoinTable(name = "contact_hobby_detail",
			   joinColumns = @JoinColumn(name = "CONTACT_ID"),
			   inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"))
	public Set<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	@Transient
	public String getBirthDateString() {
		String birthDateString = "";
		if (birthDate != null) {
			birthDateString = DateFormat.getDateTimeInstance().format(
					getBirthDate());
		}
		return birthDateString;
	}

	public String toString() {
		return "Contact - Id: " + id + ", First name: " + firstName
				+ ", Last name: " + lastName + ", Birthday: "
				+ getBirthDateString() + ", Description: " + description;
	}

}
