/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.rest.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author buhake.sindi
 * @since 2015/08/07
 *
 */
public final class Throwables {

	private Throwables() {
		throw new AssertionError("Private Constructor.");
	}
	
	public static Throwable getRootCause(Throwable throwable) {
		if (throwable == null) {
			throw new IllegalArgumentException("No exception has been provided.");
		}
		
		Throwable root = throwable;
		while (root != null) {
			Throwable cause = root.getCause();
			if (cause == null) break;
			root = cause;
		}
		
		return root;
	}
	
	public static String getStackTraceAsString(Throwable throwable) {
		if (throwable == null) {
			throw new IllegalArgumentException("No exception has been provided.");
		}
		
		StringWriter stringWriter = new StringWriter();
		throwable.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}
}
