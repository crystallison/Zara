package com.mario.zara.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mario.zara.di.modules.DispatchersModule.DispatcherIO
import com.mario.zara.domain.Result
import com.mario.zara.domain.ResultState
import com.mario.zara.domain.models.Character
import com.mario.zara.domain.models.Characters
import com.mario.zara.domain.usecases.GetCharactersByNameUseCase
import com.mario.zara.domain.usecases.GetCharactersUseCase
import com.mario.zara.presentation.states.CharactersViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    @DispatcherIO private val dispatcherIO: CoroutineDispatcher,
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getCharactersByNameUseCase: GetCharactersByNameUseCase
) : ViewModel() {

    var charactersViewState by mutableStateOf<CharactersViewState>(
        CharactersViewState.LoadingCharacters
    )
        private set

    private val _characters = MutableLiveData<Characters>()
    val characters: LiveData<Characters> get() = _characters

    var selectedCharacter: Character? = null
        private set

    fun getCharacters(page: Int = 1) {
        charactersViewState = CharactersViewState.LoadingCharacters

        viewModelScope.launch(dispatcherIO) {
            handleCharactersResult(getCharactersUseCase(page))
        }
    }

    fun getCharactersByName(name: String) {
        charactersViewState = CharactersViewState.LoadingCharacters

        viewModelScope.launch(dispatcherIO) {
            handleCharactersResult(getCharactersByNameUseCase(name))
        }
    }

    private fun handleCharactersResult(result: ResultState<Characters>) {
        if (result is Result.Success) {
            _characters.postValue(result.data)
            charactersViewState = CharactersViewState.CharactersLoaded
        } else {
            error("getCharactersUseCase error: $result")
        }
    }

    fun setSelectedCharacter(character: Character) {
        selectedCharacter = character
    }

    fun clearSelectedCharacter() {
        selectedCharacter = null
    }
}
