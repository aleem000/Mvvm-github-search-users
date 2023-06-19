package com.example.githubusers.di

import com.example.githubusers.manager.DefaultStringResourceManager
import com.example.githubusers.manager.DefaultToastManager
import com.example.githubusers.manager.StringResourceManager
import com.example.githubusers.manager.ToastManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface ManagerModule {

    @Binds
    fun bindStringResourceManager(defaultStringResourceManager: DefaultStringResourceManager): StringResourceManager


    @Binds
    fun bindToastManager(defaultToastManager: DefaultToastManager): ToastManager
}