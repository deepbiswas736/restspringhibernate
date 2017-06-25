package com.revolution.raipur.jerseystart;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;

import com.revolution.raipur.jerseystart.models.Employee;
import com.revolution.raipur.jerseystart.models.Manager;
import com.revolution.raipur.jerseystart.models.Project;
import com.revolution.raipur.jerseystart.models.UserLogin;
import com.revolution.raipur.jerseystart.service.api.ManagerServiceAPI;
import com.revolution.raipur.jerseystart.utils.Const;
import com.revolution.raipur.jerseystart.utils.SpringUtil;

import oracle.jdbc.proxy.annotation.Post;

@Path("manager")
public class ManagerResource {
	private int userID;
	private int managerID;
	private String projectID;
	private String customerName;
	private String Name;
	private ApplicationContext context;
	private SpringUtil springUtil;
	private String message;
	private ManagerServiceAPI managerService;
	private ArrayList<Employee> employeeList;
	private Manager manager;
	
	@Post
	@Path("project")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response makeProject(@Context HttpServletRequest request, @Context HttpServletResponse response, Project project) {
		
		springUtil = SpringUtil.getInstance();
		context=SpringUtil.getApplicationContext();
		managerService = (ManagerServiceAPI) context.getBean("ManagerService");
		setMessage(managerService.createProject(project));
		if (message.equals(Const.success)) {
			return Response.ok().build();
		} else {
			return Response.status(Response.Status.FORBIDDEN).build();
		}
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	public ManagerServiceAPI getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerServiceAPI managerService) {
		this.managerService = managerService;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	

	


}
