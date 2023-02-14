package com.mario.zara.domain

import com.mario.zara.data.models.CharactersDto
import com.mario.zara.domain.models.Character
import com.mario.zara.domain.models.Characters
import com.mario.zara.domain.models.Info
import com.mario.zara.domain.models.Location
import javax.inject.Inject

internal class DataMapper @Inject constructor() {
    fun toDomain(dto: CharactersDto): Characters =
        Characters(
            info = Info(
                nrCharacters = dto.infoDto.nrCharacters,
                nrPages = dto.infoDto.nrPages,
                prevUrl = dto.infoDto.prevUrl,
                nextUrl = dto.infoDto.nextUrl
            ),
            characters = dto.charactersDto.map {
                Character(
                    id = it.id,
                    name = it.name,
                    status = it.status,
                    species = it.species,
                    type = it.type,
                    gender = it.gender,
                    origin = Location(
                        name = it.originDto.name,
                        url = it.originDto.url
                    ),
                    location = Location(
                        name = it.locationDto.name,
                        url = it.locationDto.url
                    ),
                    imageUrl = it.imageUrl,
                    episodeList = it.episodeList,
                    url = it.url,
                    creationDate = it.creationDate
                )
            }
        )
}
