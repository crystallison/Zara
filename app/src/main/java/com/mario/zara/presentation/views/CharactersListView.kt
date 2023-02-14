package com.mario.zara.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mario.zara.R
import com.mario.zara.presentation.components.PageIndicator
import com.mario.zara.presentation.components.SearchBox
import com.mario.zara.presentation.screens.CharactersListScreen
import com.mario.zara.presentation.screens.LoadingDataScreen
import com.mario.zara.presentation.states.CharactersViewState
import com.mario.zara.presentation.theme.Spacing
import com.mario.zara.presentation.viewmodels.MainViewModel
import com.mario.zara.utils.OnClick

@Composable
internal fun CharactersListView(
    viewModel: MainViewModel,
    onCharacterClick: OnClick
) {
    var searchName by remember { mutableStateOf("") }
    var currentPage by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(vertical = Spacing.s, horizontal = Spacing.m)) {
        SearchBox(
            modifier = Modifier.fillMaxWidth(),
            hint = stringResource(R.string.characters_list_search_hint),
            value = searchName,
            onValueChange = { value -> searchName = value },
            onSearchClick = { name -> viewModel.getCharactersByName(name) },
        )
        Spacer(modifier = Modifier.height(Spacing.m))
        PageIndicator(
            currentPage = currentPage,
            maxPages = viewModel.characters.observeAsState().value?.info?.nrPages ?: 0L,
            onPageClick = { page ->
                currentPage = page
                viewModel.getCharacters(page = page)
            },
        )
        Spacer(modifier = Modifier.height(Spacing.s))
        when (viewModel.charactersViewState) {
            CharactersViewState.LoadingCharacters -> {
                LoadingDataScreen()
            }
            CharactersViewState.CharactersLoaded -> {
                CharactersListScreen(
                    characters = viewModel.characters.observeAsState().value?.characters ?: emptyList(),
                    onCharacterClick = { character ->
                        viewModel.setSelectedCharacter(character)
                        onCharacterClick()
                    }
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getCharacters()
    }
}
