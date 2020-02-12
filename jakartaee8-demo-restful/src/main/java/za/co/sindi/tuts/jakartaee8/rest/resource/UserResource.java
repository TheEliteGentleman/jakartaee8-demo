/**
 * 
 */
package za.co.sindi.tuts.jakartaee8.rest.resource;

import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;

import za.co.sindi.tuts.jakartaee8.repository.entity.enums.Gender;
import za.co.sindi.tuts.jakartaee8.rest.entity.Count;
import za.co.sindi.tuts.jakartaee8.service.UserService;
import za.co.sindi.tuts.jakartaee8.service.dto.UserDTO;

/**
 * @author buhake.sindi
 * @since 2017/08/17
 *
 */
@Path("/user")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UserResource {
	
	private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTERN);
	
	static {
		DATE_FORMAT.setLenient(false);
	}

	@Inject
	private UserService userService;
	
	@GET
	@Path("/count")
	@Operation(
	        summary = "Counts all users.",
	        description = "Returns the total numbers of users in the repository.")
	public Count countAllUsers() {
		return new Count(userService.countAllUsers());
	}
	
	@GET
	@Path("/{user-name:[a-zA-Z0-9_]+}")
	@Operation(
	        summary = "Get the user based on provided username.",
	        description = "Returns the user (if found) based on the provided username.")
	public UserDTO getUser(@PathParam("user-name") final String userId) {
		return userService.findUser(userId);
	}
	
	@GET
	@Path("/list")
	public Collection<UserDTO> getAllUsers() {
		return userService.findAllUsers();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createNewUser(@FormParam("user-name") final String userId, 
								  @FormParam("first-name") final String firstName,
								  @FormParam("middle-name") final String middleName, 
								  @FormParam("surname") final String surname, 
								  @FormParam("date-of-birth") final String dateOfBirth, 
								  @FormParam("birth-gender") final String birthGender) {
		try {
			userService.createNewUser(userId, firstName, middleName, surname, DATE_FORMAT.parse(dateOfBirth), Gender.of(birthGender));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(e);
		}
		return Response.created(URI.create("/" + userId)).entity(getUser(userId)).build();
	}
	
	@PUT
	@Path("/{user-name:[a-zA-Z0-9_]+}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateExistingUser(@PathParam("user-name") final String userId, 
			  @FormParam("first-name") final String firstName,
			  @FormParam("middle-name") final String middleName, 
			  @FormParam("surname") final String surname, 
			  @FormParam("date-of-birth") final String dateOfBirth, 
			  @FormParam("birth-gender") final String birthGender) {
		try {
			userService.updateExistingUser(userId, firstName, middleName, surname, DATE_FORMAT.parse(dateOfBirth), Gender.of(birthGender));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(e);
		}
		return Response.ok().entity(getUser(userId)).build();
	}
	
	@DELETE
	@Path("/{user-name:[a-zA-Z0-9_]+}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response deleteExistingUser(@PathParam("user-name") @NotNull final String userId) {
		userService.deleteUser(userId);
		return Response.noContent().build();
	}
}
