package com.samizic.espressodemo.test;

import android.test.ActivityInstrumentationTestCase2;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;
import com.samizic.espressodemo.R;
import com.samizic.espressodemo.activity.SignInActivity;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class SignInTest extends ActivityInstrumentationTestCase2<SignInActivity> {

    public SignInTest() {
        super("com.samizic.espressodemo", SignInActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testSignIn(){
        String demoUser = "DemoUser";

        onView(withId(R.id.editText_username)).perform(typeText(demoUser));

        onView(withId(R.id.editText_password)).perform(typeText("password"));

        onView(withId(R.id.btn_sign_in)).perform(click());

        onView(withId(R.id.welcome_text)).check(matches(withText("Welcome " + demoUser)));

    }

}
