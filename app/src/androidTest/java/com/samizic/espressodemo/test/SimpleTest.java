package com.samizic.espressodemo.test;

import android.test.ActivityInstrumentationTestCase2;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.action.ViewActions;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;
import com.samizic.espressodemo.R;
import com.samizic.espressodemo.activity.SimpleWelcomeActivity;

import org.hamcrest.CoreMatchers;


public class SimpleTest extends ActivityInstrumentationTestCase2<SimpleWelcomeActivity> {

    public static final String DEMO_USER = "DemoUser";

    public SimpleTest() {
        super("com.samizic.espressodemo", SimpleWelcomeActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testWelcomeTextNotVisibleOnStart(){
        Espresso.onView(ViewMatchers.withId(R.id.welcome_text))
                .check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.isDisplayed())));
    }

    public void testWelcomeTextVisibleWhenNameEnteredAndButtonPressed(){
        Espresso.onView(ViewMatchers.withId(R.id.editText_username))
                .perform(ViewActions.typeText(DEMO_USER));

        Espresso.onView(ViewMatchers.withId(R.id.btn_say_hello))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.welcome_text))
                .check(ViewAssertions.matches( ViewMatchers.isDisplayed()) );

        Espresso.onView(ViewMatchers.withId(R.id.welcome_text))
                .check(ViewAssertions.matches(ViewMatchers.withText("Welcome " + DEMO_USER)) );
    }

    public void testWelcomeTextNotVisibleWhenEmptyNameAndButtonPressed(){
        Espresso.onView(ViewMatchers.withId(R.id.editText_username))
                .perform(ViewActions.typeText(""));

        Espresso.onView(ViewMatchers.withId(R.id.btn_say_hello))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.welcome_text))
                .check(ViewAssertions.matches( CoreMatchers.not(ViewMatchers.isDisplayed())) );

        Espresso.onView(ViewMatchers.withId(R.id.welcome_text))
                .check(ViewAssertions.matches(ViewMatchers.withText("")) );
    }

}
