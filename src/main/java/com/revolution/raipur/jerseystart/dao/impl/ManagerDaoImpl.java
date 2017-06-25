package com.revolution.raipur.jerseystart.dao.impl;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import com.revolution.raipur.jerseystart.dao.api.ManagerDaoAPI;
import com.revolution.raipur.jerseystart.models.Employee;
import com.revolution.raipur.jerseystart.models.Manager;
import com.revolution.raipur.jerseystart.models.Project;
import com.revolution.raipur.jerseystart.utils.Const;
import com.revolution.raipur.jerseystart.utils.HibernateUtil;
import com.revolution.raipur.jerseystart.utils.SpringUtil;



public class ManagerDaoImpl implements ManagerDaoAPI{
	private SessionFactory sessionFactory;
	private HibernateUtil hibernateUtil;
	private SpringUtil springUtil;
	private ApplicationContext context;
	private String message;
	private ArrayList<Employee> employeeList;
	private ArrayList<Project> projectList;
	private Manager manager;
	@Override
	public String fillDetails(Manager manager) {
		hibernateUtil = HibernateUtil.getInstance();
		sessionFactory=HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Employee e1 = new Employee();
		try{
		
		session.beginTransaction();
		e1=(Employee)session.get(Employee.class,manager.getUserID());
		System.out.print(manager.getName());
		e1.setName(manager.getName());
		session.getTransaction().commit();
		setMessage(Const.success);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			setMessage(Const.error);
		}
		finally{
			session.close();
		}
		System.out.println(message);
		return message;
	}

	@Override
	public String createProject(Project project) {
		hibernateUtil = HibernateUtil.getInstance();
		sessionFactory=HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try{
		
		session.beginTransaction();
		session.save(project);
		session.getTransaction().commit();
		setMessage(Const.success);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			setMessage(Const.error);
		}
		finally{
			session.close();
		}
		System.out.println(message);
		return message;
	}
	@Override
	public ArrayList<Employee> showEmployee() {
		hibernateUtil = HibernateUtil.getInstance();
		sessionFactory=HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try{
			
			session.beginTransaction();
			org.hibernate.Query query = session.createQuery("from Employee where project_projectID is null");
			List Result =query.list();
			System.out.println(Result.size());
			employeeList = ((ArrayList<Employee>) Result);
			session.getTransaction().commit();
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally{
				session.close();
			}
		
		return employeeList;
	}
	@Override
	public ArrayList<Project> showProject() {
		hibernateUtil = HibernateUtil.getInstance();
		sessionFactory=HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try{
			
			session.beginTransaction();
			org.hibernate.Query query = session.createQuery("from Project");
			List Result =query.list();
			projectList = ((ArrayList<Project>) Result);
			session.getTransaction().commit();
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally{
				session.close();
			}
		return projectList;
	}
	@Override
	public String deleteProject(String projectID) {
		hibernateUtil = HibernateUtil.getInstance();
		sessionFactory=HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Project project;
		try{
		session.beginTransaction();
		project = (Project) session.get(Project.class, projectID);
		for(Employee e : project.getEmployeeList())
		{
			e.setProject(null);
			session.update(e);
		}
		session.delete(project);
		session.getTransaction().commit();
		setMessage(Const.success);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			setMessage(Const.error);
		}
		finally{
			session.close();
		}
		System.out.println(message);
		return message;
		
	}

	@Override
	public Manager showDetails(int userid) {
		hibernateUtil = HibernateUtil.getInstance();
		sessionFactory=HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
			manager =(Manager) session.get(Manager.class,userid);
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return manager;
	}

	@Override
	public String AddEmployee(int userid,String projectID) {
		
		System.out.println(projectID);
		hibernateUtil = HibernateUtil.getInstance();
		sessionFactory=HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Project project;
		Employee employee;
		try{
		
		session.beginTransaction();
		project = (Project) session.get(Project.class, projectID);
		employee =(Employee) session.get(Employee.class,userid);
		project.getEmployeeList().add(employee);
		employee.setProject(project);
		session.update(project);
		session.update(employee);
		session.getTransaction().commit();
		setMessage(Const.success);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			setMessage(Const.error);
		}
		finally{
			session.close();
		}
		System.out.println(message);
		return message;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	public SpringUtil getSpringUtil() {
		return springUtil;
	}

	public void setSpringUtil(SpringUtil springUtil) {
		this.springUtil = springUtil;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
