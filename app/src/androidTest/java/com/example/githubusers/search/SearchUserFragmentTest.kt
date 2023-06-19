package com.example.githubusers.search

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.githubusers.R
import com.example.githubusers.app.MainActivity
import com.example.githubusers.features.search.presentation.ui.SearchUserFragment
import com.example.githubusers.utils.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@LargeTest
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class SearchUserFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)


    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun isFragmentVisible() {
        launchFragmentInHiltContainer<SearchUserFragment> { }
        onView(withId(R.id.fragment_search_user)).check(matches(isDisplayed()))
    }

}