/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.service.dto.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import za.co.sindi.tuts.jakartaee8.repository.entity.enums.Gender;

/**
 * @author Bienfait Sindi
 * @xince 25 June 2015
 *
 */
public class GenderAdapter extends XmlAdapter<String, Gender> {

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public Gender unmarshal(String value) throws Exception {
		// TODO Auto-generated method stub
		return Gender.of(value);
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public String marshal(Gender gender) throws Exception {
		// TODO Auto-generated method stub
		return (gender == null ? null : gender.toString());
	}
}
