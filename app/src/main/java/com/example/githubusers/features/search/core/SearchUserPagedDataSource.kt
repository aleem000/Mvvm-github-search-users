package com.example.githubusers.features.search.core

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.githubusers.features.search.data.Item
import com.example.githubusers.utils.DEFAULT_PAGE
import com.example.githubusers.utils.default
import com.example.githubusers.utils.minus
import timber.log.Timber
import javax.inject.Inject


class SearchUserPagedDataSource @Inject constructor(private val service: SearchAPIService) :
    PagingSource<Int, Item>() {

    private var _login: String? = null

    fun setLogin(login: String) {
        this._login = login
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> = try {
        val position = params.key ?: DEFAULT_PAGE
        val response = service.getUsersByLogin(_login.default(), position)
        LoadResult.Page(
            response.items?.sortedBy { it.login?.lowercase() }.orEmpty(),
            if (position == 1) null else position - 1,
            position + 1
        )
    } catch (e: Exception) {
        Timber.e(e)
        LoadResult.Error(e)
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: (anchorPage?.nextKey minus 1)
        }
}