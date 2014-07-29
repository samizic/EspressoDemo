package com.samizic.espressodemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.samizic.espressodemo.R;
import com.samizic.espressodemo.service.login.LoginError;
import com.samizic.espressodemo.service.login.LoginManager;
import com.samizic.espressodemo.service.login.LoginResponseListener;
import com.samizic.espressodemo.service.user.UserDetails;
import com.samizic.espressodemo.service.user.UserManager;


public class SignInActivity extends Activity {

	private EditText _username;
	private EditText _password;
	private Button 	_signInButton;
    private ProgressBar _loadingView;

	private LoginManager _loginManager;
	private UserManager _userManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        _loginManager = LoginManager.getInstance();
        _userManager =_loginManager.getUserManager();

		_username = 		(EditText) 	findViewById(R.id.editText_username);
		_password = 		(EditText) 	findViewById(R.id.editText_password);
		_signInButton =		(Button) 	findViewById(R.id.btn_sign_in);
		_loadingView =		(ProgressBar)findViewById(R.id.loading_view);

		_signInButton.setOnClickListener(new OnSignInClickListener());
        _loadingView.setVisibility(View.GONE);
    }

	private class OnSignInClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			String username = _username.getText().toString();
			String password = _password.getText().toString();

            _loadingView.setVisibility(View.VISIBLE);

			_loginManager.logIn(username, password, new LoginResponseListener() {
				@Override
				public void onSuccess(String username, String password, String accountType) {
                    _loadingView.setVisibility(View.GONE);
					UserDetails user = new UserDetails(username, password, accountType);
					_userManager.setUser(user);
                    Intent intent = new Intent(SignInActivity.this, WelcomeActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
				}

				@Override
				public void onError(LoginError error) {
                    _loadingView.setVisibility(View.GONE);
					Toast.makeText(SignInActivity.this, error.message, Toast.LENGTH_LONG).show();
				}
			});
		}
	}

}
