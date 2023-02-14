package com.mario.zara.domain.usecases

import com.mario.zara.domain.ResultState

interface ParameterizedSuspendUseCase<TInput, TOutput> {
    suspend operator fun invoke(input: TInput): ResultState<TOutput>
}
