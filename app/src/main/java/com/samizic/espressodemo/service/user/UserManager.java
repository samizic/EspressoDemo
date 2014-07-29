package com.samizic.espressodemo.service.user;


public class UserManager {

	private UserDetails _user = UserDetails.EMPTY;

    private static UserManager _instance;


	private UserManager() { }

    public static UserManager getInstance() {
        if(_instance == null){
            _instance = new UserManager();
        }
        return _instance;
    }

	public void setUser(UserDetails user){
		if(user != null){
			_user = user;
		}
	}

	public boolean isSignedIn(){
		return _user != UserDetails.EMPTY;
	}

	public void clearUser() {
		_user = UserDetails.EMPTY;
	}

	public UserDetails getUser() {
		return _user;
	}


}
