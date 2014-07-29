package com.samizic.espressodemo.matchers;

import com.samizic.espressodemo.pojo.CustomObject;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static com.google.android.apps.common.testing.testrunner.util.Checks.checkNotNull;
import static org.hamcrest.CoreMatchers.is;

public class CustomObjectMatchers {

    private CustomObjectMatchers() {
    }

    public static Matcher<CustomObject> withItemTitle(final String expectedTitle)
    {
        return withItemTitle(is(expectedTitle));
    }

    public static Matcher<CustomObject> withItemTitle(final Matcher<String> stringMatcher)
    {
        // use preconditions to fail fast when a test is creating an invalid matcher.
        checkNotNull(stringMatcher);

        return new TypeSafeMatcher<CustomObject>() {

            @Override
            public boolean matchesSafely(CustomObject customObject) {
                String title = customObject.getTitle();

                return stringMatcher.matches(title);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with item title: ");
                stringMatcher.describeTo(description);

            }
        };

    }
}
