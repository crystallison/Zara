package com.mario.zara.di.modules

import com.mario.zara.data.repositories.CharactersRepository
import com.mario.zara.data.repositories.CharactersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoriesModule {
    @Binds
    abstract fun bindCharactersRepository(
        charactersRepository: CharactersRepositoryImpl
    ): CharactersRepository
}
