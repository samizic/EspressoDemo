package com.samizic.espressodemo.service.login;

import android.os.AsyncTask;

public class MockLoginDataService implements LoginDataService {

	public MockLoginDataService() {
	}

	public void doEremedyLogin(final String username, final String password, final LoginResponseListener listener)
	{
        AsyncTask<Void, Void, Void> signInAsyncTask = new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                listener.onSuccess(username, password, "DemoUser");
            }
        };


        signInAsyncTask.execute();

	}

}
