package com.example.githubusers.app

import com.example.githubusers.R
import com.example.githubusers.base.BaseActivity
import com.example.githubusers.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

		override fun getLayout(): Int = R.layout.activity_main
}