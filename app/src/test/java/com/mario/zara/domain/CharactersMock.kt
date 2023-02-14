package com.mario.zara.domain

import com.mario.zara.domain.models.Character
import com.mario.zara.domain.models.Characters
import com.mario.zara.domain.models.Info
import com.mario.zara.domain.models.Location

class CharactersMock {
    val exampleData = Characters(
        info = Info(
            nrCharacters = 30,
            nrPages = 3,
            prevUrl = "prevUrl",
            nextUrl = "nextUrl"
        ),
        characters = listOf(
            Character(
                id = 0,
                name = "Rick",
                status = "Alive",
                species = "Human",
                type = "Human",
                gender = "Male",
                origin = Location(
                    name = "Earth",
                    url = "originUrl"
                ),
                location = Location(
                    name = "Earth",
                    url = "locationUrl"
                ),
                imageUrl = "imageUrl",
                episodeList = listOf(),
                url = "url",
                creationDate = "creationDate"
            )
        )
    )
}
