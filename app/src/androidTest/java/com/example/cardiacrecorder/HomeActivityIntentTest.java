package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeActivityIntentTest {
    @Rule
    public ActivityScenarioRule<HomePageActivity> activityRule =
            new ActivityScenarioRule<>(HomePageActivity.class);
    @Test
    public void testHomePage()
    {
        onView(withText("ADD MEASUREMENTS")).check(matches(isDisplayed()));
        onView(withText("MEASUREMENT HISTORY")).check(matches(isDisplayed()));
        onView(withId(R.id.image_add)).check(matches(isDisplayed()));
        onView(withId(R.id.image_history)).check(matches(isDisplayed()));
        onView(withId(R.id.firstCard)).check(matches(isDisplayed()));
        onView(withId(R.id.secondCard)).check(matches(isDisplayed()));
        onView(withId(R.id.image_add)).perform(click());
        Espresso.pressBack();
        onView(withId(R.id.image_history)).perform(click());
    }

}
