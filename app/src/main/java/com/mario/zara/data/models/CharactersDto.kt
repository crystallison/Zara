package com.mario.zara.data.models

import com.google.gson.annotations.SerializedName

data class CharactersDto(
    @SerializedName("info") val infoDto: InfoDto,
    @SerializedName("results") val charactersDto: List<CharacterDto>
)

data class InfoDto(
    @SerializedName("count") val nrCharacters: Long,
    @SerializedName("pages") val nrPages: Long,
    @SerializedName("next") val nextUrl: String?,
    @SerializedName("prev") val prevUrl: String?
)
