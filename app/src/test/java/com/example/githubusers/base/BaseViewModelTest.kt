package com.example.githubusers.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.githubusers.utils.EMPTY_STRING
import com.example.githubusers.utils.equals
import junit.framework.AssertionFailedError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule

@ExperimentalCoroutinesApi
abstract class BaseViewModelTest {

		@get:Rule
		val instantTaskExecutorRule = InstantTaskExecutorRule()
		private val dispatcher = TestCoroutineDispatcher()

		@Before
		fun setupDispatchers() {
				Dispatchers.setMain(dispatcher)
		}

		@After
		fun tearDownDispatchers() {
				Dispatchers.resetMain()
		}

		fun <T> assertNotEmpty(list: List<T>?) {
				if (list.isNullOrEmpty()) throw AssertionFailedError()
				else assertNotNull(list)

		}

		fun assertNotEmpty(value: Any?) {
				if (value equals EMPTY_STRING) throw AssertionFailedError()
				else assertNotNull(value)
		}
}