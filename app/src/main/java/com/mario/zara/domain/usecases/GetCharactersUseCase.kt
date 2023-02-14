package com.mario.zara.domain.usecases

import com.mario.zara.data.repositories.CharactersRepository
import com.mario.zara.domain.DataMapper
import com.mario.zara.domain.Result
import com.mario.zara.domain.ResultState
import com.mario.zara.domain.models.Characters
import javax.inject.Inject

internal interface GetCharactersUseCase : ParameterizedSuspendUseCase<Int, Characters>

internal class GetCharactersUseCaseImpl @Inject constructor(
    private val repository: CharactersRepository,
    private val dataMapper: DataMapper
) : GetCharactersUseCase {
    override suspend fun invoke(input: Int): ResultState<Characters> =
        Result.Success(dataMapper.toDomain(repository.getCharacters(input)))
}
