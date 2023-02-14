package com.mario.zara.domain.usecases

import com.mario.zara.domain.models.Characters
import com.mario.zara.domain.DataMapper
import com.mario.zara.domain.Result
import com.mario.zara.domain.ResultState
import com.mario.zara.data.repositories.CharactersRepository
import javax.inject.Inject

internal interface GetCharactersByNameUseCase : ParameterizedSuspendUseCase<String, Characters>

internal class GetCharactersByNameUseCaseImpl @Inject constructor(
    private val repository: CharactersRepository,
    private val dataMapper: DataMapper
) : GetCharactersByNameUseCase {
    override suspend fun invoke(input: String): ResultState<Characters> =
        Result.Success(dataMapper.toDomain(repository.getCharactersByName(input)))
}
