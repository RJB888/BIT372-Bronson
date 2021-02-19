package com.example.unitcoverter;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.unitcoverter", appContext.getPackageName());
    }

    @Test
    public void can_enter_fahrenheit() {
        onView(withId(R.id.conversion_spinner)).perform(click());
        onView(withText("F to C")).perform(click());
        onView(withId(R.id.input_field)).perform(typeText("45"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.output_text)).check(matches(withText("7.22 ºC")));
    }

    @Test
    public void should_not_enter_empty_fah() {
        onView(withId(R.id.conversion_spinner)).perform(click());
        onView(withText("F to C")).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.output_text)).check(matches(withText("")));
    }

    @Test
    public void can_enter_pounds() {
        onView(withId(R.id.conversion_spinner)).perform(click());
        onView(withText("lb to kg")).perform(click());
        onView(withId(R.id.input_field)).perform(typeText("2"));
        onView((withId(R.id.convert_btn))).perform(click());
        onView(withId(R.id.output_text)).check(matches(withText("0.91 kg")));
    }

    @Test
    public void can_enter_zero() {
        onView(withId(R.id.conversion_spinner)).perform(click());
        onView(withText("lb to kg")).perform(click());
        onView(withId(R.id.input_field)).perform(typeText("0"));
        onView((withId(R.id.convert_btn))).perform(click());
        onView(withId(R.id.output_text)).check(matches(withText("0.00 kg")));
    }

    @Test
    public void can_enter_decimals() {
        onView(withId(R.id.conversion_spinner)).perform(click());
        onView(withText("lb to kg")).perform(click());
        onView(withId(R.id.input_field)).perform(typeText("2.2"));
        onView((withId(R.id.convert_btn))).perform(click());
        onView(withId(R.id.output_text)).check(matches(withText("1.00 kg")));
    }

    @Test
    public void selection_changes_title(){
        onView(withId(R.id.fahrenheit_title)).check(matches(withText("Fahrenheit to Celcius")));
        onView(withId(R.id.conversion_spinner)).perform(click());
        onView(withText("ft to m")).perform(click());
        onView(withId(R.id.fahrenheit_title)).check(matches(withText("Feet to Meters")));
    }

}