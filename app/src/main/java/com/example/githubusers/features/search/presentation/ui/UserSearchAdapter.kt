package com.example.githubusers.features.search.presentation.ui

import android.view.ViewGroup
import com.example.githubusers.base.BasePagedAdapter
import com.example.githubusers.base.BasePagedViewHolder
import com.example.githubusers.databinding.ItemSearchUserBinding
import com.example.githubusers.features.search.data.Item
import com.example.githubusers.utils.inflater


class UserSearchAdapter(override var itemClickListener: (Item) -> Unit) : BasePagedAdapter<Item, UserSearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserSearchViewHolder {
        val binding = ItemSearchUserBinding.inflate(parent.inflater, parent, false)
        return UserSearchViewHolder(binding, itemClickListener)
    }
}

class UserSearchViewHolder(private val binding: ItemSearchUserBinding, private val itemClickListener: (Item) -> Unit) : BasePagedViewHolder<Item>(binding.root) {

    override fun onBind(item: Item, position: Int) {
        binding.users = item
        binding.root.setOnClickListener {
            itemClickListener.invoke(item)
        }

    }
}