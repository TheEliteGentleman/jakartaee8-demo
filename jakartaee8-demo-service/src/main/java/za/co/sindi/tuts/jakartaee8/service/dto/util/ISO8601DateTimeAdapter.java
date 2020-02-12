/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.service.dto.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Bienfait Sindi
 * @xince 05 July 2015
 *
 */
public class ISO8601DateTimeAdapter extends XmlAdapter<String, Date> {

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public Date unmarshal(String value) throws Exception {
		// TODO Auto-generated method stub
		return DatatypeConverter.parseDate(value).getTime();
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public String marshal(Date date) throws Exception {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		c.clear();
		c.setTime(date);
		return DatatypeConverter.printDateTime(c);
	}
}
