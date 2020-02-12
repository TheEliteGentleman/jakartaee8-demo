/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.rest.provider;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;
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
public class PersistenceExceptionMapper implements ExceptionMapper<PersistenceException> {
	
	private static final Logger LOGGER = Logger.getLogger(PersistenceExceptionMapper.class.getName());
	
	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(PersistenceException exception) {
		// TODO Auto-generated method stub
		if (LOGGER.isLoggable(Level.SEVERE)) {
			LOGGER.log(Level.SEVERE, "JAX-RS caught the following exception:", exception);
		}
		
		if (exception.getCause() instanceof ConstraintViolationException) {
			return new ConstraintViolationExceptionMapper().toResponse((ConstraintViolationException) exception.getCause());
		}
		
		return Response.status(Status.UNPROCESSABLE_ENTITY).entity(new Exception(exception)).build();
	}
}
