package com.linoop.bluefox.presentation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.linoop.bluefox.R
import com.linoop.bluefox.presentation.views.SplashActivity

@RunWith(AndroidJUnit4::class)
@LargeTest
class SplashActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(SplashActivity::class.java)

    @Test
    fun testButtonClick() {
        onView(withId(R.id.myButton)).perform(click())
        onView(withId(R.id.myTextView)).check(matches(withText("Clicked")))
    }

    /*private lateinit var scenario: ActivityScenario<LoginActivity>

    @Before
    fun setup() {
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun login(){
        //onView(withId(R.id.userID)).perform(typeText("22"))
        //onView(withId(R.id.priceThree)).perform(typeText("33"))
        closeSoftKeyboard()
        onView(withId(R.id.login)).perform(click())
        *//*Truth.assertThat(
            Espresso.onView(ViewMatchers.withId(R.id.itemCode))
                .check(ViewAssertions.matches(ViewMatchers.withText("1234")))
        )*//*
    }*/
}