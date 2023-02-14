package com.mario.zara.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mario.zara.R
import com.mario.zara.domain.models.Character
import com.mario.zara.presentation.theme.Spacing
import com.mario.zara.utils.toFullMonthDate

@OptIn(ExperimentalCoilApi::class, ExperimentalComposeUiApi::class)
@Composable
internal fun CharacterDetailsScreen(character: Character) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(vertical = Spacing.xl),
            text = stringResource(R.string.character_name_placeholder, character.id, character.name),
            style = MaterialTheme.typography.h1
        )
        Image(
            painter = rememberImagePainter(character.imageUrl),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(Spacing.xl))
        CharacterData(
            label = stringResource(R.string.character_creation_label),
            text = character.creationDate.toFullMonthDate()
        )
        CharacterData(
            label = stringResource(R.string.character_status_label),
            text = character.status
        )
        CharacterData(
            label = stringResource(R.string.character_species_label),
            text = character.species
        )
        CharacterData(
            label = stringResource(R.string.character_gender_label),
            text = character.gender
        )
        CharacterData(
            label = stringResource(R.string.character_type_label),
            text = character.type
        )
        CharacterData(
            label = stringResource(R.string.character_origin_label),
            text = character.origin.name
        )
        CharacterData(
            label = stringResource(R.string.character_location_label),
            text = character.location.name
        )
        CharacterData(
            label = stringResource(R.string.character_episodes_label),
            text = pluralStringResource(
                R.plurals.character_episodes_plural,
                character.episodeList.size,
                character.episodeList.size
            )
        )

        val uriHandler = LocalUriHandler.current
        ClickableText(
            text = AnnotatedString(stringResource(R.string.character_link_label)),
            style = MaterialTheme.typography.body1.copy(
                color = MaterialTheme.colors.primary
            ),
            onClick = { uriHandler.openUri(character.url) }
        )
    }
}

@Composable
private fun CharacterData(
    label: String,
    text: String
) {
    Text(
        text = label,
        style = MaterialTheme.typography.body2
    )
    Spacer(modifier = Modifier.height(Spacing.xxs))
    Text(
        text = text.ifBlank { stringResource(R.string.character_unknown_text) },
        style = MaterialTheme.typography.body1
    )
    Spacer(modifier = Modifier.height(Spacing.m))
}
