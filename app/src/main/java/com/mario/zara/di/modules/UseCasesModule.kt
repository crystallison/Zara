package com.mario.zara.di.modules

import com.mario.zara.domain.usecases.GetCharactersByNameUseCase
import com.mario.zara.domain.usecases.GetCharactersByNameUseCaseImpl
import com.mario.zara.domain.usecases.GetCharactersUseCase
import com.mario.zara.domain.usecases.GetCharactersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCasesModule {
    @Binds
    abstract fun bindGetCharactersUseCase(
        implementation: GetCharactersUseCaseImpl,
    ): GetCharactersUseCase

    @Binds
    abstract fun bindGetCharactersByNameUseCase(
        implementation: GetCharactersByNameUseCaseImpl,
    ): GetCharactersByNameUseCase
}
