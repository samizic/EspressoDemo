package com.samizic.espressodemo.service.login;

import com.samizic.espressodemo.service.user.UserManager;


public class LoginManager {

	UserManager _userManager;
	LoginDataService _loginDataService;

    public static LoginManager getInstance(){
        return new LoginManager(UserManager.getInstance(), new MockLoginDataService());
    }

	private LoginManager(UserManager _userManager, LoginDataService _loginDataService) {
		this._userManager = _userManager;
		this._loginDataService = _loginDataService;
	}

	public void logIn(String username, String password, LoginResponseListener listener){

		if(!areCredentialsValid(username, password)){
			listener.onError(LoginError.INCORRECT_USERNAME_OR_PASSWORD);
		}
		else{
			doUserLogIn(username, password, listener);
		}

	}

	private void doUserLogIn(String username, String password, LoginResponseListener listener) {
		_loginDataService.doEremedyLogin(username, password, listener);
	}


	public void logOut(){
		_userManager.clearUser();
	}

	private boolean areCredentialsValid(String username, String password) {
		return username != null && username.length() > 0 && password != null && password.length() > 0;
	}

    public UserManager getUserManager() {
        return _userManager;
    }
}
