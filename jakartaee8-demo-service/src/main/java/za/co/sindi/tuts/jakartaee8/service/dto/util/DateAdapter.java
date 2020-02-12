/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.service.dto.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Bienfait Sindi
 * @xince 05 July 2015
 *
 */
public class DateAdapter extends XmlAdapter<String, Date> {

	private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTERN);
	
	static {
		DATE_FORMAT.setLenient(false);
	}
	
	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public Date unmarshal(String value) throws Exception {
		// TODO Auto-generated method stub
		return DATE_FORMAT.parse(value);
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public String marshal(Date date) throws Exception {
		// TODO Auto-generated method stub
		return DATE_FORMAT.format(date);
	}
}
