package com.mario.zara.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mario.zara.presentation.viewmodels.MainViewModel
import com.mario.zara.presentation.views.CharacterDetailsView
import com.mario.zara.presentation.views.CharactersListView

@Composable
internal fun MainNavHost(viewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainRoute.CHARACTERS_LIST.name,
    ) {
        composable(MainRoute.CHARACTERS_LIST.name) {
            CharactersListView(
                viewModel = viewModel,
                onCharacterClick = {
                    navController.navigate(MainRoute.CHARACTER_DETAILS.name) {
                        restoreState = true
                    }
                }
            )
        }
        composable(MainRoute.CHARACTER_DETAILS.name) {
            CharacterDetailsView(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

