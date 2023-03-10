package com.linoop.bluefox.presentation.views.fragments

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.TypeTextAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.linoop.bluefox.presentation.views.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.linoop.bluefox.R
import org.junit.Before

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class CreateUserFragmentTest{

    @get: Rule
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup(){
        onView(withId(R.id.gotoCreateUser)).perform(click())
    }

    @Test
    fun testCreateUser(){
        onView(withId(R.id.editTextEmail)).perform(typeText("xxxxx"))
        closeSoftKeyboard()
        onView(withId(R.id.save)).perform(click())
        onView(withText("That's not a valid email")).check(matches(isDisplayed()))


        onView(withId(R.id.editTextEmail)).perform(typeText("linoopxxx@gmail.com"))
        onView(withId(R.id.editTextName)).perform(typeText("Linoopxxx"))
        onView(withId(R.id.editTextAddress)).perform(typeText("Kochi"), pressImeActionButton())
        onView(withId(R.id.editTextPassword)).perform(typeText("1234567890a"), pressImeActionButton())
        onView(withId(R.id.editTextPasswordConfirm)).perform(typeText("1234567890a"), pressImeActionButton())
        closeSoftKeyboard()
        onView(withId(R.id.save)).perform(click())

        /*onView(withId(R.id.itemCode)).perform(typeText("1234"))
        onView(withId(R.id.itemName)).perform(typeText("abc"))
        onView(withId(R.id.priceOne)).perform(typeText("12"))
        //onView(withId(R.id.priceTwo)).perform(typeText("22"))
        //onView(withId(R.id.priceThree)).perform(typeText("33"))
        closeSoftKeyboard()
        onView(withId(R.id.save)).perform(click())
        assertThat(onView(withId(R.id.itemCode)).check(matches(withText("1234"))))*/

        /*To verify if dialog appears you can simply check if View with a text that present inside the dialog is shown:

        onView(withText("dialogText")).check(matches(isDisplayed()));

        or, based on text with id

        onView(withId(R.id.myDialogTextId)).check(matches(allOf(withText(myDialogText), isDisplayed()));

        To click on dialogs button do this (button1 - OK, button2 - Cancel):
        onView(withId(android.R.id.button1)).perform(click());*/
    }

}