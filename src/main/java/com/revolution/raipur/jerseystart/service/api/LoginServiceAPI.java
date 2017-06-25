package com.revolution.raipur.jerseystart.service.api;
import com.revolution.raipur.jerseystart.models.UserLogin;

public interface LoginServiceAPI {
	public boolean UserLoginExists (int i );
	public void updateUserLogin(UserLogin UserLogin ) ;
	public String authenticateUserLogin(UserLogin UserLogin) ;
	public UserLogin getUserLogin(String UserLoginname );
	public void persistUserLogin (UserLogin UserLogin );
	public String createUser(UserLogin userLogin);

}
