package com.revolution.raipur.jerseystart.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;

import com.revolution.raipur.jerseystart.dao.api.LoginDaoAPI;
import com.revolution.raipur.jerseystart.models.UserLogin;
import com.revolution.raipur.jerseystart.utils.Const;
import com.revolution.raipur.jerseystart.utils.HibernateUtil;
import com.revolution.raipur.jerseystart.utils.SpringUtil;

public class LoginDaoImpl implements LoginDaoAPI{
	private SessionFactory sessionFactory;
	private SpringUtil springUtil;
	private ApplicationContext context;
	private String message;
	private HibernateUtil hibernateUtil;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateUtil getHibernateUtil() {
		return getHibernateUtil();
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

	
	@Override
	public String createUser(UserLogin userLogin) {
		
		springUtil = SpringUtil.getInstance();
		context=SpringUtil.getApplicationContext();
		UserLogin temp = (UserLogin) context.getBean(userLogin.getRole());
		temp.setUserID(userLogin.getUserID());
		temp.setPassword(userLogin.getPassword());
		temp.setRole(userLogin.getRole());
		hibernateUtil = HibernateUtil.getInstance();
		sessionFactory =HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try{
		session.beginTransaction();
		session.save(temp);
		session.getTransaction().commit();
		setMessage("Success");
		}
		catch(Exception e){
			e.printStackTrace();
			setMessage("Error");
		}
		finally{
		session.close();
		}
		return message;
	}

	@Override
	public boolean UserLoginExists(int UserLoginname) {
		// TODO Auto-generated method stub
		
		hibernateUtil = HibernateUtil.getInstance();
		sessionFactory =HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		org.hibernate.Query query = session.createQuery("from UserLogin where userID = :userID");
		query.setParameter("userID", UserLoginname);
		UserLogin user = (UserLogin)query.uniqueResult();
		return true;
	}

	@Override
	public UserLogin getUserLogin(String UserLoginname) {
		
		return null;
	}

	@Override
	public String authenticateUserLogin(UserLogin userLogin) {
		
		
		hibernateUtil = HibernateUtil.getInstance();
		sessionFactory =HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		org.hibernate.Query query = session.createQuery("from UserLogin where userID = :userID");
		query.setParameter("userID", userLogin.getUserID());
		UserLogin user=null;
		user=(UserLogin)query.uniqueResult();
		
		if(user==null)
			setMessage(Const.errorPage);
		else
			setMessage(user.getRole());
		session.getTransaction().commit();
		session.close();
		return message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
