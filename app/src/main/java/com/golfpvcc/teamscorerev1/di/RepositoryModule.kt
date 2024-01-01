package com.golfpvcc.teamscorerev1.di

import com.golfpvcc.teamscorerev1.database.repository.RepositoryImpl
import com.golfpvcc.teamscorerev1.domain.repository.Repository
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
    abstract fun bindRepository(repositoryImpl: RepositoryImpl):Repository

}