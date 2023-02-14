package com.mario.zara.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.res.stringResource
import com.mario.zara.R
import com.mario.zara.presentation.components.Toolbar
import com.mario.zara.presentation.screens.CharacterDetailsScreen
import com.mario.zara.presentation.viewmodels.MainViewModel
import com.mario.zara.utils.OnClick

@Composable
internal fun CharacterDetailsView(
    viewModel: MainViewModel,
    onBackClick: OnClick
) {
    Column {
        Toolbar(
            text = stringResource(R.string.character_details_title),
            onBackClick = onBackClick
        )
        CharacterDetailsScreen(
            character = viewModel.selectedCharacter ?: error("Selected character was null")
        )
    }

    DisposableEffect(Unit) {
        onDispose { viewModel.clearSelectedCharacter() }
    }
}
