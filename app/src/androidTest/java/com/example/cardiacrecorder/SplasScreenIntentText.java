package com.example.cardiacrecorder;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SplasScreenIntentText {

    @Rule
    public ActivityScenarioRule<splashScreen> activityRule =
            new ActivityScenarioRule<>(splashScreen.class);

    @Test
    public void testSplashScreen() {
        onView(withId(R.id.keep_fit_img)).check(matches(isDisplayed()));
        onView(withText("KEEP")).check(matches(isDisplayed()));
        onView(withText("FIT")).check(matches(isDisplayed()));
        onView(withText("Abdullah Al Shafi")).check(matches(isDisplayed()));
        onView(withText("Roll:1807004")).check(matches(isDisplayed()));
        onView(withText("Shihab Newaz")).check(matches(isDisplayed()));
        onView(withText("Roll:1807023")).check(matches(isDisplayed()));
    }



}
