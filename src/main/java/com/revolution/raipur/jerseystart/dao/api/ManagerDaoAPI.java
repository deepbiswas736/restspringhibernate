package com.revolution.raipur.jerseystart.dao.api;
import java.util.ArrayList;

import com.revolution.raipur.jerseystart.models.Employee;
import com.revolution.raipur.jerseystart.models.Manager;
import com.revolution.raipur.jerseystart.models.Project;


public interface ManagerDaoAPI {
	public String fillDetails(Manager manager);
	public String createProject(Project project);
	public String deleteProject(String projectID);
	public Manager showDetails(int userid);
	public String AddEmployee(int userid,String projectID);
	public ArrayList<Employee> showEmployee();
	public ArrayList<Project> showProject();
}
