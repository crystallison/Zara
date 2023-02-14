package com.mario.zara.data.repositories

import com.mario.zara.data.ApiService
import com.mario.zara.data.models.CharactersDto
import javax.inject.Inject

internal interface CharactersRepository {
    suspend fun getCharacters(page: Int): CharactersDto
    suspend fun getCharactersByName(name: String): CharactersDto
}

internal class CharactersRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CharactersRepository {
    override suspend fun getCharacters(page: Int): CharactersDto = apiService.getCharacters(page)
    override suspend fun getCharactersByName(name: String): CharactersDto = apiService.getCharactersByName(name)
}
