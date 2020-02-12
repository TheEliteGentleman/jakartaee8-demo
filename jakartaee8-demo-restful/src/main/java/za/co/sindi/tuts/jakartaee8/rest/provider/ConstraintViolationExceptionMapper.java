/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.rest.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import za.co.sindi.tuts.jakartaee8.rest.Status;

/**
 * @author Buhake Sindi
 * @since 2018/07/02
 *
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	private static final Logger LOGGER = Logger.getLogger(ConstraintViolationExceptionMapper.class.getName());
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(ConstraintViolationException exception) {
		// TODO Auto-generated method stub
		if (LOGGER.isLoggable(Level.SEVERE)) {
			LOGGER.log(Level.SEVERE, "JAX-RS caught the following exception:", exception);
		}
		
		List<Error> errors = new ArrayList<>();
		for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
			errors.add(new Error(String.format("%s - %s", violation.getPropertyPath(), violation.getMessage())));
		}

		return Response.status(Status.UNPROCESSABLE_ENTITY).entity(errors).build();
	}

//	private static Path.Node getLastNodePath(Iterator<Path.Node> iterator) {
//		Path.Node lastElement = iterator.next();
//
//		while (iterator.hasNext()) {
//			lastElement = iterator.next();
//		}
//
//		return lastElement;
//	}
}
