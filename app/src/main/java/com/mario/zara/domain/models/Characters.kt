package com.mario.zara.domain.models

data class Characters(
    val characters: List<Character>,
    val info: Info
)

data class Info(
    val nrCharacters: Long,
    val nrPages: Long,
    val nextUrl: String?,
    val prevUrl: String?
)
