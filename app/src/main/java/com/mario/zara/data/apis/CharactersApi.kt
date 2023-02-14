package com.mario.zara.data.apis

import com.mario.zara.data.models.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharactersDto
    suspend fun getCharactersByName(@Query("name") name: String): CharactersDto
}
