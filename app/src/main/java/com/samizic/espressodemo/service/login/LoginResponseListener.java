package com.samizic.espressodemo.service.login;

public interface LoginResponseListener {

	public void onSuccess(String username, String password, String accountType);

	public void onError(LoginError error);
}
