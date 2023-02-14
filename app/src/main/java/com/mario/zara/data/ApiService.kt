package com.mario.zara.data

import com.mario.zara.data.apis.CharactersApi
import com.mario.zara.data.models.CharactersDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

internal class ApiService @Inject constructor() {
    private val baseUrl = "https://rickandmortyapi.com/api/"
    private val instance = Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val charactersApi = instance.create(CharactersApi::class.java)

    suspend fun getCharacters(page: Int): CharactersDto = charactersApi.getCharacters(page)
    suspend fun getCharactersByName(name: String): CharactersDto = charactersApi.getCharactersByName(name)
}
