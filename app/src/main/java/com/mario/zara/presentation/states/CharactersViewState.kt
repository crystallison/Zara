package com.mario.zara.presentation.states

internal sealed class CharactersViewState : ViewState {
    object LoadingCharacters : CharactersViewState()
    object CharactersLoaded : CharactersViewState()
}
