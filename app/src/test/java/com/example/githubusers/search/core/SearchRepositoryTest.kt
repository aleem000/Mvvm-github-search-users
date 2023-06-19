package com.example.githubusers.search.core

import com.nhaarman.mockitokotlin2.any
import com.example.githubusers.features.search.core.DefaultSearchUserRepository
import com.example.githubusers.features.search.core.SearchUserPagedDataSource
import com.example.githubusers.features.search.core.SearchUserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchRepositoryTest {

		private lateinit var searchUserRepository: SearchUserRepository

		@Mock
		private lateinit var searchUserPagedDataSource: SearchUserPagedDataSource

		@Before
		fun setup() {
				searchUserRepository = DefaultSearchUserRepository(searchUserPagedDataSource)
		}

		@Test
		fun `search user by query`() = runBlocking {
				val login = "User"
				searchUserPagedDataSource.run {
						this.setLogin(login)
						this.load(any())
				}

				val actual = searchUserRepository.getUsersByLogin(login)

				assertNotNull(actual)
		}
}