package com.mario.zara.data.models

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val originDto: LocationDto,
    @SerializedName("location") val locationDto: LocationDto,
    @SerializedName("image") val imageUrl: String,
    @SerializedName("episode") val episodeList: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val creationDate: String
)

data class LocationDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
