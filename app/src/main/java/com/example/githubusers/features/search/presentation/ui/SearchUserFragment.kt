package com.example.githubusers.features.search.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.githubusers.base.BaseFragment
import com.example.githubusers.databinding.FragmentSearchUserBinding
import com.example.githubusers.features.search.presentation.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchUserFragment : BaseFragment<FragmentSearchUserBinding>() {

    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var userSearchAdapter: UserSearchAdapter

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchUserBinding {
        return FragmentSearchUserBinding.inflate(inflater, container, false).apply {
            viewModel = searchViewModel
            userSearchAdapter = UserSearchAdapter { item ->
                searchViewModel.onItemClick(item)
            }
            adapter = userSearchAdapter
        }
    }

    override fun onFragmentReady() {
        searchViewModel.onInit()
        observerUsers()
    }

    private fun observerUsers() {
        searchViewModel.pagedData.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                userSearchAdapter.submitData(it)
            }
        }
    }

}