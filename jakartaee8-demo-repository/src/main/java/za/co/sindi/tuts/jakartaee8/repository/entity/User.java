/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.repository.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import za.co.sindi.tuts.jakartaee8.repository.entity.enums.Gender;

/**
 * @author buhake.sindi
 * @since 2017/08/17
 *
 */
/**
 * @author Bienfait Sindi
 * @since 31 December 2013
 *
 */
@Entity
@Table(name="USER")
@Access(AccessType.FIELD)
@NamedQueries({
	@NamedQuery(name="user.countAllDeleted", query="SELECT COUNT(u) FROM User u WHERE u.deletionTimestamp IS NOT NULL"),
//	@NamedQuery(name="user.existsByEmail", query="SELECT CASE WHEN (COUNT(u) > 0) THEN true ELSE false END FROM UserEmailAddress u WHERE u.id = ?1"),
	@NamedQuery(name="user.findAllNonDeleted", query="SELECT u from User u WHERE u.deletionTimestamp IS NULL"),
//	@NamedQuery(name="user.findByEmailAddress", query="SELECT u FROM User u JOIN u.emailAddresses e WHERE e.id = ?1"),
	@NamedQuery(name="user.findByName", query="SELECT u FROM User u WHERE UPPER(TRIM(u.firstName)) LIKE ?1 OR UPPER(TRIM(u.surname)) LIKE ?1 OR UPPER(CONCAT(TRIM(u.firstName), ' ', TRIM(u.surname))) LIKE ?1 OR UPPER(CONCAT(TRIM(u.firstName), ' ', TRIM(u.secondName), ' ', TRIM(u.surname))) LIKE ?1")
})
public class User implements za.co.sindi.tuts.jakartaee8.repository.entity.Entity<String>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1600376007707987934L;

	@Id
	@Column(name="USER_NAME", nullable=false)
	private String id;
	
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;
	
	@Column(name="SECOND_NAME", nullable=false)
	private String secondName;
	
	@Column(name="SURNAME", nullable=false)
	private String surname;
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE", nullable=false)
	private Date birthDate;
	
	@Column(name="BIRTH_GENDER", columnDefinition="ENUM('M', 'F')", nullable=false)
	@Enumerated(EnumType.STRING)
	private Gender birthGender;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_TIMESTAMP", nullable=false, insertable=false, updatable=false)
	private Date creationTimestamp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_MODIFICATION_TIMESTAMP", insertable=false)
	private Date lastModificationTimestamp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DELETION_TIMESTAMP", insertable=false)
	private Date deletionTimestamp;

	/* (non-Javadoc)
	 * @see za.co.sindi.entity.Entity#isNew()
	 */
	public boolean isNew() {
		// TODO Auto-generated method stub
		String id = getId();
		if (id == null) {
			return true;
		}
		
		return false;
	}

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
