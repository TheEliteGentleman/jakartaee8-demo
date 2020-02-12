/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.service.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import za.co.sindi.tuts.jakartaee8.repository.entity.enums.Gender;
import za.co.sindi.tuts.jakartaee8.service.dto.util.DateAdapter;
import za.co.sindi.tuts.jakartaee8.service.dto.util.GenderAdapter;
import za.co.sindi.tuts.jakartaee8.service.dto.util.ISO8601DateTimeAdapter;

/**
 * @author Bienfait Sindi
 * @since 07 June 2015
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="user")
public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4838106011014786695L;

	@XmlElement
	private String id;
	
	@XmlElement(name="first_name")
	private String firstName;
	
	@XmlElement(name="middle_name")
	private String secondName;
	
	@XmlElement(name="surname")
	private String surname;
	
	@XmlElement(name="birth_date")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date birthDate;
	
	@XmlElement(name="birth_gender")
	@XmlJavaTypeAdapter(GenderAdapter.class)
	private Gender birthGender;
	
	@XmlElement(name="created_on")
	@XmlJavaTypeAdapter(ISO8601DateTimeAdapter.class)
	private Date creationTimestamp;
		
	@XmlElement(name="last_modified_on", nillable=true)
	@XmlJavaTypeAdapter(ISO8601DateTimeAdapter.class)
	private Date lastModificationTimestamp;
		
	@XmlElement(name="deleted_on", nillable=true)
	@XmlJavaTypeAdapter(ISO8601DateTimeAdapter.class)
	private Date deletionTimestamp;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * @param secondName the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the birthGender
	 */
	public Gender getBirthGender() {
		return birthGender;
	}

	/**
	 * @param birthGender the birthGender to set
	 */
	public void setBirthGender(Gender birthGender) {
		this.birthGender = birthGender;
	}

	/**
	 * @return the creationTimestamp
	 */
	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	/**
	 * @param creationTimestamp the creationTimestamp to set
	 */
	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	/**
	 * @return the lastModificationTimestamp
	 */
	public Date getLastModificationTimestamp() {
		return lastModificationTimestamp;
	}

	/**
	 * @param lastModificationTimestamp the lastModificationTimestamp to set
	 */
	public void setLastModificationTimestamp(Date lastModificationTimestamp) {
		this.lastModificationTimestamp = lastModificationTimestamp;
	}

	/**
	 * @return the deletionTimestamp
	 */
	public Date getDeletionTimestamp() {
		return deletionTimestamp;
	}

	/**
	 * @param deletionTimestamp the deletionTimestamp to set
	 */
	public void setDeletionTimestamp(Date deletionTimestamp) {
		this.deletionTimestamp = deletionTimestamp;
	}
}
