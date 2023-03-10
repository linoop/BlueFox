package com.linoop.bluefox.presentation.views.fragments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.linoop.bluefox.presentation.views.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.linoop.bluefox.R
import com.linoop.bluefox.presentation.views.UserListAdapter
import org.junit.Before


@RunWith(AndroidJUnit4::class)
class UserListFragmentTest {
    @get:Rule
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        onView(withId(R.id.login)).perform(click())
    }

    @Test
    fun testRecyclerViewVisibleOnAppLaunch() {
        onView(withId(R.id.userList)).check(matches(isDisplayed()))
    }

    @Test
    fun testRecyclerViewItemClickIsDisplayDetails() {
        onView(withId(R.id.userList))
            .perform(actionOnItemAtPosition<UserListAdapter.UserListViewHolder>(0, click()))
        onView(withId(R.id.username)).check(matches(withText("linoop")))
    }

    @Test
    fun testRecyclerViewItemClickOnBackPressed() {
        onView(withId(R.id.userList))
            .perform(actionOnItemAtPosition<UserListAdapter.UserListViewHolder>(0, click()))
        onView(withId(R.id.username)).check(matches(withText("linoop")))
        pressBack()
        onView(withId(R.id.userListActivity)).check(matches(isDisplayed()))
    }
}