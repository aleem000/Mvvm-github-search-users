package com.example.githubusers.search.core

import androidx.paging.PagingData
import com.nhaarman.mockitokotlin2.whenever
import com.example.githubusers.features.search.core.DefaultSearchUserUseCase
import com.example.githubusers.features.search.core.SearchUserRepository
import com.example.githubusers.features.search.core.SearchUserUseCase
import com.example.githubusers.features.search.data.Item
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchUseCaseTest {

		private lateinit var searchUserUseCase: SearchUserUseCase

		@Mock
		private lateinit var repository: SearchUserRepository

		@Before
		fun setup() {
				searchUserUseCase = DefaultSearchUserUseCase(repository)
		}

		@Test
		fun `search user`() = runBlocking {
				val login = "User"
				val data = flowOf(PagingData.from(getDummyItems()))
				whenever(repository.getUsersByLogin(login)).thenReturn(data)

				val actual = searchUserUseCase.searchUser(login)

				assertNotNull(actual)
		}
		private fun getDummyItems() = listOf(Item(login = "User", type = "User", avatar_url = "https://avatars.githubusercontent.com/u/33724757?v=4"))

}