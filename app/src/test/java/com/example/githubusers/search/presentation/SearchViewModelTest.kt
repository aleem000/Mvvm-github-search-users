package com.example.githubusers.search.presentation

import androidx.paging.PagingData
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.example.githubusers.R
import com.example.githubusers.base.BaseViewModelTest
import com.example.githubusers.features.search.core.SearchUserUseCase
import com.example.githubusers.features.search.data.Item
import com.example.githubusers.features.search.presentation.viewmodel.SearchViewModel
import com.example.githubusers.manager.StringResourceManager
import com.example.githubusers.manager.ToastManager
import com.example.githubusers.utils.EMPTY_STRING
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest : BaseViewModelTest() {

		private lateinit var searchViewModel: SearchViewModel

		@Mock
		private lateinit var stringResourceManager: StringResourceManager

		@Mock
		private lateinit var toastManager: ToastManager

		@Mock
		private lateinit var searchUseCase: SearchUserUseCase

		@Before
		fun setup() {
				searchViewModel = SearchViewModel(searchUseCase, toastManager, stringResourceManager)
		}

		@Test
		fun `on init`() = runBlocking {

				searchViewModel.onInit()

				assertNotNull(searchViewModel.scope.value)
		}

		@Test
		fun `search user when search query is empty`() = runBlocking {
				val errorMessage = "Please enter a valid query"
				whenever(stringResourceManager.getString(eq(R.string.empty_searched_text))).thenReturn(errorMessage)

				searchViewModel.searchUser(EMPTY_STRING)

				verify(toastManager).showToast(errorMessage)

		}

		@Test
		fun `search user when search is not empty`() = runBlocking {
				val login = "UserName"
				val data = flowOf(PagingData.from(getDummyItems()))
				whenever(searchUseCase.searchUser(login)).thenReturn(data)

				searchViewModel.searchUser(login)

				assertNotNull(searchViewModel.pagedData.value)

		}

		@Test
		fun `when list item is tapped`() = runBlocking {
				val item = getDummyItems().first()
				val message = "Clicked item 01"
				whenever(stringResourceManager.getString(eq(R.string.item_click),anyString())).thenReturn(message)

				searchViewModel.onItemClick(item)

				verify(toastManager).showToast(message)
		}

		private fun getDummyItems() = listOf(Item(login = "UserName", type = "User", avatar_url = "https://avatars.githubusercontent.com/u/33724757?v=4"))
}