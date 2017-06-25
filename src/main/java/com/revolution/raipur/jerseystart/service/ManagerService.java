package com.revolution.raipur.jerseystart.service;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import com.revolution.raipur.jerseystart.dao.api.ManagerDaoAPI;
import com.revolution.raipur.jerseystart.models.Employee;
import com.revolution.raipur.jerseystart.models.Manager;
import com.revolution.raipur.jerseystart.models.Project;
import com.revolution.raipur.jerseystart.service.api.ManagerServiceAPI;
import com.revolution.raipur.jerseystart.utils.SpringUtil;



public class ManagerService implements ManagerServiceAPI {
	private ApplicationContext context;
	private SpringUtil springUtil;
	private String message;
	private ManagerDaoAPI managerDao;
	private ArrayList<Employee> employeeList;
	private ArrayList<Project> projectList;
	private Manager manager;
	@Override
	public String fillDetails(Manager manager) {
		
		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		managerDao=(ManagerDaoAPI) context.getBean("ManagerDao");
		setMessage(managerDao.fillDetails(manager));
		System.out.println(message);
		return message;
	}

	@Override
	public String createProject(Project project) {
		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		managerDao=(ManagerDaoAPI) context.getBean("ManagerDao");
		setMessage(managerDao.createProject(project));
		System.out.println(message);
		return message;
	}
	@Override
	public ArrayList<Employee> showEmployee() {
		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		managerDao=(ManagerDaoAPI) context.getBean("ManagerDao");
		employeeList=managerDao.showEmployee();
		return employeeList;
	}
	
	@Override
	public ArrayList<Project> showProject() {
		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		managerDao=(ManagerDaoAPI) context.getBean("ManagerDao");
		projectList=managerDao.showProject();
		return projectList;
	}
	@Override
	public String deleteProject(String projectID) {
		
		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		managerDao=(ManagerDaoAPI) context.getBean("ManagerDao");
		setMessage(managerDao.deleteProject(projectID));
		return message;
	}

	@Override
	public Manager showDetails(int userid) {
		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		managerDao=(ManagerDaoAPI) context.getBean("ManagerDao");
		manager=managerDao.showDetails(userid);
		return manager;
		
	}

	@Override
	public String AddEmployee(int userid,String projectID) {
		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		managerDao=(ManagerDaoAPI) context.getBean("ManagerDao");
		setMessage(managerDao.AddEmployee(userid, projectID));
		return message;
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

	public ManagerDaoAPI getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDaoAPI managerDao) {
		this.managerDao = managerDao;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public ArrayList<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(ArrayList<Project> projectList) {
		this.projectList = projectList;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
