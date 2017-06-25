package com.revolution.raipur.jerseystart.service;

import org.springframework.context.ApplicationContext;
import com.revolution.raipur.jerseystart.dao.api.LoginDaoAPI;
import com.revolution.raipur.jerseystart.models.UserLogin;
import com.revolution.raipur.jerseystart.service.api.LoginServiceAPI;
import com.revolution.raipur.jerseystart.utils.SpringUtil;

public class LoginService implements LoginServiceAPI{
	
	private LoginDaoAPI loginDao;
	SpringUtil springUtil;
	ApplicationContext context;
	private String message;
	
	 
	@Override
	public boolean UserLoginExists(int UserLoginname) {
		
		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		loginDao = (LoginDaoAPI) context.getBean("LoginDao");
		return loginDao.UserLoginExists(UserLoginname);
		
	}

	@Override
	public void updateUserLogin(UserLogin UserLogin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String authenticateUserLogin(UserLogin userLogin) {
		
		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		loginDao = (LoginDaoAPI) context.getBean("LoginDao");
		setMessage(loginDao.authenticateUserLogin(userLogin));
		return message;
	}

	@Override
	public UserLogin getUserLogin(String UserLoginname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persistUserLogin(UserLogin UserLogin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String createUser(UserLogin userLogin) {
		
		springUtil = SpringUtil.getInstance();
		context = SpringUtil.getApplicationContext();
		loginDao = (LoginDaoAPI) context.getBean("LoginDao");
		setMessage(loginDao.createUser(userLogin));
		return message;
				
	}

	public LoginDaoAPI getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDaoAPI loginDao) {
		this.loginDao = loginDao;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
