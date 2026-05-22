package com.sri.testnetworkcall.di

import com.sri.testnetworkcall.ui.screens.home.viewmodel.UsersListRepository
import com.sri.testnetworkcall.ui.screens.home.viewmodel.UsersListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPostListRepository(
        usersListRepositoryImpl: UsersListRepositoryImpl
    ): UsersListRepository
}