package com.example.githubusers.features.search.presentation.ui

import androidx.databinding.BindingAdapter
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.features.search.data.PagingState
import com.example.githubusers.utils.EMPTY_STRING
import com.example.githubusers.utils.PagingStateListener


@BindingAdapter(value = ["state_listener"])
fun RecyclerView.bindUsers(
    listener: PagingStateListener
) {
    (adapter as UserSearchAdapter?)?.addLoadStateListener { loadState ->
        if (loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading) {
            listener.onState(PagingState.LOADING)
        } else {
            listener.onState(
                PagingState.NOT_LOADING,
                (loadState.refresh as? LoadState.Error?)?.error?.message ?: EMPTY_STRING
            )
        }
    }
}
