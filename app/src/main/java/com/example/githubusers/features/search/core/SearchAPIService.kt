package com.example.githubusers.features.search.core

import com.example.githubusers.features.search.data.UserSearchResponse
import com.example.githubusers.utils.DEFAULT_PAGE
import com.example.githubusers.utils.DEFAULT_PAGE_LIMIT
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPIService {

		@GET("search/users")
		suspend fun getUsersByLogin(
				@Query("q") login: String,
				@Query("page") page: Int = DEFAULT_PAGE,
				@Query("per_page") limit: Int = DEFAULT_PAGE_LIMIT
		): UserSearchResponse
}