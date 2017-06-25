package com.revolution.raipur.jerseystart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;

import com.revolution.raipur.jerseystart.models.UserLogin;
import com.revolution.raipur.jerseystart.service.api.LoginServiceAPI;
import com.revolution.raipur.jerseystart.utils.Const;
import com.revolution.raipur.jerseystart.utils.SpringUtil;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
	private LoginServiceAPI loginServiceAPI;
	ApplicationContext context;
	SpringUtil springUtil;
	private String message;


    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("login")
	public Response login(@Context HttpServletRequest request, @Context HttpServletResponse response, UserLogin user) {
		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		loginServiceAPI = (LoginServiceAPI) context.getBean("loginService");
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		this.setMessage(loginServiceAPI.authenticateUserLogin(user));
		if (message.equals(Const.success)) {
			return Response.ok().build();
		} else {
			return Response.status(Response.Status.FORBIDDEN).entity(user).build();
		}

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("register")
	public Response register(@Context HttpServletRequest request, @Context HttpServletResponse response,
			UserLogin user) {

		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		loginServiceAPI = (LoginServiceAPI) context.getBean("loginService");
		setMessage(loginServiceAPI.createUser(user));
		if (message.equals(Const.success)) {
			return Response.ok().build();
		} else {
			return Response.status(Response.Status.FORBIDDEN).build();
		}
	}

	public LoginServiceAPI getLoginServiceAPI() {
		return loginServiceAPI;
	}

	public void setLoginServiceAPI(LoginServiceAPI loginServiceAPI) {
		this.loginServiceAPI = loginServiceAPI;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public SpringUtil getSpringUtil() {
		return springUtil;
	}

	public void setSpringUtil(SpringUtil springUtil) {
		this.springUtil = springUtil;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
