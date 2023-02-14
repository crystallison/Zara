package com.mario.zara.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.mario.zara.R
import com.mario.zara.presentation.theme.Spacing
import com.mario.zara.presentation.theme.ZaraTheme
import com.mario.zara.domain.models.Character
import com.mario.zara.utils.OnCharacterClick

@Composable
internal fun CharactersListScreen(
    characters: List<Character>,
    onCharacterClick: OnCharacterClick
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(Spacing.s)) {
        items(
            count = characters.size,
            key = { characters[it].id },
            itemContent = { index ->
                CharacterListItem(
                    character = characters[index],
                    onClick = onCharacterClick
                )
            }
        )
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun CharacterListItem(
    character: Character,
    onClick: OnCharacterClick
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(character) },
        elevation = Spacing.xs,
        shape = RoundedCornerShape(Spacing.s),
        backgroundColor = Color.DarkGray
    ) {
        Row(
            modifier = Modifier.padding(Spacing.s),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(character.imageUrl) { size(OriginalSize) },
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(Spacing.m))
            Column {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.h3,
                    color = Color.White
                )
                Text(
                    text = "${character.status} - ${character.species} - ${character.gender}",
                    style = MaterialTheme.typography.h4,
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(Spacing.s))
                Text(
                    text = stringResource(R.string.character_origin_label),
                    style = MaterialTheme.typography.caption
                )
                Spacer(modifier = Modifier.height(Spacing.xxs))
                Text(
                    text = character.origin.name,
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(Spacing.s))
                Text(
                    text = stringResource(R.string.character_location_label),
                    style = MaterialTheme.typography.caption
                )
                Spacer(modifier = Modifier.height(Spacing.xxs))
                Text(
                    text = character.location.name,
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ZaraTheme {
        CharactersListScreen(
            characters = emptyList(),
            onCharacterClick = {}
        )
    }
}
