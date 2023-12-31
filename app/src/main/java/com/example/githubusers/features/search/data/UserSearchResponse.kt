package com.example.githubusers.features.search.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserSearchResponse(
        val incomplete_results: Boolean? = null,
        val items: List<Item>? = null,
        val total_count: Long? = null
) : Parcelable

@Parcelize
data class Item(
        val avatar_url: String? = null,
        val events_url: String? = null,
        val followers_url: String? = null,
        val following_url: String? = null,
        val gists_url: String? = null,
        val gravatar_id: String? = null,
        val html_url: String? = null,
        val id: Long? = null,
        val login: String? = null,
        val node_id: String? = null,
        val organizations_url: String? = null,
        val received_events_url: String? = null,
        val repos_url: String? = null,
        val score: Double? = null,
        val site_admin: Boolean? = null,
        val starred_url: String? = null,
        val subscriptions_url: String? = null,
        val type: String? = null,
        val url: String? = null
) : Parcelable