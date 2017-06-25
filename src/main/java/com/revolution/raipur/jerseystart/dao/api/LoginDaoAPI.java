package com.revolution.raipur.jerseystart.dao.api;
import com.revolution.raipur.jerseystart.models.UserLogin;

public interface LoginDaoAPI {
	public String createUser(UserLogin userLogin);
	public boolean UserLoginExists (int userLoginname );
	public UserLogin getUserLogin(String UserLoginname );
	public String authenticateUserLogin(UserLogin userLogin);
}
