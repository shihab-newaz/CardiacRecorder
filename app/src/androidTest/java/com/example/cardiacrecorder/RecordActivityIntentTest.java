package com.example.cardiacrecorder;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecordActivityIntentTest {
    @Rule
    public ActivityScenarioRule<RecordActivity> activityRule =
            new ActivityScenarioRule<>(RecordActivity.class);
    @Test
    public void testHomePage()
    {
        onView(withText("Create Record")).check(matches(isDisplayed()));
        onView(withId(R.id.date)).perform(ViewActions.typeText("12/12/12"));
        onView(withId(R.id.time)).perform(ViewActions.typeText("10:00 A.M."));
        onView(withId(R.id.systolicPressure)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.diastolicPressure)).perform(ViewActions.typeText("80"));
        onView(withId(R.id.heartRate)).perform(ViewActions.typeText("60"));
        onView(withId(R.id.comment)).perform(ViewActions.typeText("resting"));
        onView(withId(R.id.saveButton)).perform(click());
    }
}
