package com.example.githubusers.search.core

import androidx.paging.PagingSource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import com.example.githubusers.features.search.core.SearchAPIService
import com.example.githubusers.features.search.core.SearchUserPagedDataSource
import com.example.githubusers.features.search.data.UserSearchResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchUserPagedDataSourceTest {

		private lateinit var dataSource: SearchUserPagedDataSource

		@Mock
		private lateinit var apiService: SearchAPIService

		@Before
		fun setup() {
		}

		@Test
		fun `verify results`() = runBlocking {
				whenever(apiService.getUsersByLogin(any(), any(), any())).thenReturn(getMockResponse())

				dataSource = SearchUserPagedDataSource(apiService)

				val expected = PagingSource.LoadResult.Page(
								data = listOf(),
								prevKey = null,
								nextKey = 2
				)

				val actual = dataSource.load(
								PagingSource.LoadParams.Refresh(
												key = null,
												loadSize = 2,
												placeholdersEnabled = false
								)
				)
				assertEquals(expected, actual)

		}

		private fun getMockResponse() = UserSearchResponse(true, listOf(), 10)
}