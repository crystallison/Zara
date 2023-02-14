package com.mario.zara.domain.models

data class Character(
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val imageUrl: String,
    val episodeList: List<String>,
    val url: String,
    val creationDate: String
)

data class Location(
    val name: String,
    val url: String
)
