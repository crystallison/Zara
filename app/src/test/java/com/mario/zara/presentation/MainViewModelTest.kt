package com.mario.zara.presentation

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEmpty
import assertk.assertions.isNotEqualTo
import assertk.assertions.isNotNull
import assertk.assertions.isNull
import com.mario.zara.domain.CharactersMock
import com.mario.zara.domain.Result
import com.mario.zara.domain.usecases.GetCharactersByNameUseCaseImpl
import com.mario.zara.domain.usecases.GetCharactersUseCaseImpl
import com.mario.zara.presentation.states.CharactersViewState
import com.mario.zara.presentation.viewmodels.MainViewModel
import com.mario.zara.utils.InstantExecutor
import com.mario.zara.utils.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutor::class)
@OptIn(ExperimentalCoroutinesApi::class)
internal class MainViewModelTest {
    private val dispatcher = UnconfinedTestDispatcher()
    private val charactersMock = CharactersMock()
    private val getCharactersUseCase = mockk<GetCharactersUseCaseImpl>(relaxed = true)
    private val getCharactersByNameUseCase = mockk<GetCharactersByNameUseCaseImpl>(relaxed = true)

    private val viewModel = spyk(
        MainViewModel(
            dispatcherIO = dispatcher,
            getCharactersUseCase = getCharactersUseCase,
            getCharactersByNameUseCase = getCharactersByNameUseCase
        )
    )

    @Test
    fun `CharactersViewState should be LoadingCharacters on creation`() {
        assertThat(viewModel.charactersViewState).isEqualTo(CharactersViewState.LoadingCharacters)
    }

    @Test
    fun `Characters list should be null on creation`() {
        assertThat(viewModel.characters.getOrAwaitValue(0)).isNull()
    }

    @Test
    fun `Selected Character should be empty on creation`() {
        assertThat(viewModel.selectedCharacter).isNull()
    }

    @Test
    fun `CharactersViewState should be LoadingCharacters when getCharacters is called`() {
        viewModel.getCharacters(DEFAULT_PAGE)

        assertThat(viewModel.charactersViewState).isEqualTo(CharactersViewState.LoadingCharacters)
    }

    @Test
    fun `getCharactersUseCase should be invoked when getCharacters is called`() = runTest {
        viewModel.getCharacters(DEFAULT_PAGE)

        coVerify(exactly = 1) {
            getCharactersUseCase.invoke(DEFAULT_PAGE)
        }
    }

    @Test
    fun `Characters LiveData should be populated after getCharactersUseCase is finished`() = runTest {
        coEvery { getCharactersUseCase.invoke(DEFAULT_PAGE) } returns Result.Success(charactersMock.exampleData)

        val characters = viewModel.characters.getOrAwaitValue(5)

        assertThat(characters).isNotNull()
        assertThat(characters!!.characters).isNotEmpty()
    }

    @Test
    fun `CharactersViewState should be CharactersLoaded after getCharacters is finished`() {
        coEvery { getCharactersUseCase.invoke(DEFAULT_PAGE) } returns Result.Success(charactersMock.exampleData)

        viewModel.getCharacters()
        viewModel.characters.getOrAwaitValue(5)

        coVerify(exactly = 1) {
            getCharactersUseCase.invoke(DEFAULT_PAGE)
        }

        assertThat(viewModel.charactersViewState).isEqualTo(CharactersViewState.CharactersLoaded)
    }


    @Test
    fun `CharactersViewState should be LoadingCharacters when getCharactersByName is called`() {
        viewModel.getCharactersByName(DEFAULT_NAME)

        assertThat(viewModel.charactersViewState).isEqualTo(CharactersViewState.LoadingCharacters)
    }

    @Test
    fun `getCharactersByNameUseCase should be invoked when getCharactersByName is called`() = runTest {
        viewModel.getCharactersByName(DEFAULT_NAME)

        coVerify(exactly = 1) {
            getCharactersByNameUseCase.invoke(DEFAULT_NAME)
        }
    }

    @Test
    fun `Characters LiveData should be populated after getCharactersByNameUseCase is finished`() = runTest {
        coEvery { getCharactersByNameUseCase.invoke(DEFAULT_NAME) } returns Result.Success(charactersMock.exampleData)

        val characters = viewModel.characters.getOrAwaitValue(5)

        assertThat(characters).isNotNull()
    }

    @Test
    fun `CharactersViewState should be CharactersLoaded after getCharactersByName is finished`() {
        viewModel.getCharactersByName(DEFAULT_NAME)
        viewModel.characters.getOrAwaitValue(5)

        coVerify(exactly = 1) {
            getCharactersByNameUseCase.invoke(DEFAULT_NAME)
        }

        assertThat(viewModel.charactersViewState).isEqualTo(CharactersViewState.CharactersLoaded)
    }

    @Test
    fun `selectedCharacter should be set after calling setSelectedCharacter`() {
        val selectedCharacter = viewModel.selectedCharacter
        val expectedCharacter = charactersMock.exampleData.characters[0]

        viewModel.setSelectedCharacter(expectedCharacter)

        assertThat(viewModel.selectedCharacter).isNotEqualTo(selectedCharacter)
        assertThat(viewModel.selectedCharacter).isEqualTo(expectedCharacter)
    }

    private companion object {
        const val DEFAULT_PAGE = 1
        const val DEFAULT_NAME = "Rick"
    }
}
