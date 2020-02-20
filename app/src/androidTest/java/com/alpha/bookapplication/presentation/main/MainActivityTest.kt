package com.alpha.bookapplication.presentation.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.alpha.bookapplication.R
import com.alpha.bookapplication.presentation.main.adapter.CategoriesHomeAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val mainActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testInsuranceRecycleActionClick() {
        if (getItemsCount() > 0) {
            onView(withId(R.id.viewEmployees)).perform(
                actionOnItemAtPosition<CategoriesHomeAdapter.CategoryViewHolder>(
                    24,
                    click()
                )
            )
        }
    }

    @Test
    fun testInsuranceRecycleScrollToPosition() {
        val recyclerView: RecyclerView = mainActivityTestRule.activity.findViewById(R.id.viewEmployees)
        val count = recyclerView.adapter!!.itemCount
        onView(withId(R.id.viewEmployees)).perform(
            scrollToPosition<CategoriesHomeAdapter.CategoryViewHolder>(count - 1)
        )
    }

    @Test
    fun testInsuranceRecycleIsDisplayed() {

        onView(withId(R.id.viewEmployees)).check(matches(isDisplayed()))

    }

    private fun getItemsCount(): Int {
        val recyclerView: RecyclerView =
            mainActivityTestRule.activity.findViewById(R.id.viewEmployees)
        return recyclerView.adapter!!.itemCount
    }


}