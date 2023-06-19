package com.example.githubusers.features.search.core

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.githubusers.features.search.data.Item
import com.example.githubusers.utils.DEFAULT_PAGE_LIMIT
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface SearchUserRepository {
    suspend fun getUsersByLogin(login: String): Flow<PagingData<Item>>
}


class DefaultSearchUserRepository @Inject constructor(
        private val dataSource: SearchUserPagedDataSource
) : SearchUserRepository {
    override suspend fun getUsersByLogin(login: String): Flow<PagingData<Item>> {
        dataSource.setLogin(login)
        return Pager(
                config = PagingConfig(
                        pageSize = DEFAULT_PAGE_LIMIT,
                        enablePlaceholders = false,
                        initialLoadSize = DEFAULT_PAGE_LIMIT
                ),
                pagingSourceFactory = {
                    dataSource
                }
        ).flow
    }


}