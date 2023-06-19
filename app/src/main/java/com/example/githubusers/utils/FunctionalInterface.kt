package com.example.githubusers.utils

import com.example.githubusers.features.search.data.PagingState


@FunctionalInterface
interface PagingStateListener {
    fun onState(state: PagingState,message:Any?=null)
}