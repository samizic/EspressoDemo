package com.samizic.espressodemo.service.login;


public interface LoginDataService {

	void doEremedyLogin(String username, String password, LoginResponseListener listener);

}
