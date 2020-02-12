/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.rest.provider;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import za.co.sindi.tuts.jakartaee8.service.exception.BusinessException;

/**
 * @author Buhake Sindi
 * @since 2018/07/02
 *
 */
@Provider
public class BusinessExceptionExceptionMapper implements ExceptionMapper<BusinessException> {
	
	private static final Logger LOGGER = Logger.getLogger(BusinessExceptionExceptionMapper.class.getName());
	
	/* (non-Javadoc)
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(BusinessException exception) {
		// TODO Auto-generated method stub
		if (LOGGER.isLoggable(Level.SEVERE)) {
			LOGGER.log(Level.SEVERE, "JAX-RS caught the following exception:", exception);
		}
		
		String message = exception.getLocalizedMessage();
		za.co.sindi.tuts.jakartaee8.rest.entity.Error error = exception.getCause() != null ? new za.co.sindi.tuts.jakartaee8.rest.entity.Error(message, new za.co.sindi.tuts.jakartaee8.rest.entity.Exception(exception.getCause())) : new za.co.sindi.tuts.jakartaee8.rest.entity.Error(message);
		return Response.status(Status.BAD_REQUEST).entity(error).build();
	}
}
