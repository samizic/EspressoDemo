package com.samizic.espressodemo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.samizic.espressodemo.R;
import com.samizic.espressodemo.activity.AdapterActivity;
import com.samizic.espressodemo.matchers.CustomObjectMatchers;
import com.samizic.espressodemo.pojo.CustomObject;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onData;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDescendantOfA;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

public class AdapterItemTest extends ActivityInstrumentationTestCase2<AdapterActivity> {

    public AdapterItemTest() {
        super("com.samizic.espressodemo", AdapterActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }


    public void testAdapterItemsClickShowsCorrectTextOnNewActivity(){

        onData(allOf(
                is(instanceOf(CustomObject.class)),
                CustomObjectMatchers.withItemTitle("Item #5")) )
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(isDisplayed()))
                .check(matches(withText("Item #5")));

    }

    public void testAdapterItemClickTakesYouToCorrectScreen(){

        onData(allOf(is(instanceOf(CustomObject.class)),
                CustomObjectMatchers.withItemTitle("Item #3")) )
                .perform(click());

        onView(allOf(isDescendantOfA(withResourceName("android:id/action_bar_container")),
                withText("Item #3 Details")))
                .check(matches(isDisplayed()));

    }



    // Methods return Custom Matchers that match views with resource name

    public static Matcher<View> withResourceName(String resourceName) {
        return withResourceName(is(resourceName));
    }

    public static Matcher<View> withResourceName(final Matcher<String> resourceNameMatcher) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("with resource name: ");
                resourceNameMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                int id = view.getId();
                return id != View.NO_ID
                        && id != 0
                        && view.getResources() != null
                        && resourceNameMatcher.matches(view.getResources().getResourceName(id));
            }
        };
    }


}
