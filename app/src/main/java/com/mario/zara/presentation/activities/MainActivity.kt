package com.mario.zara.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mario.zara.presentation.navigation.MainNavHost
import com.mario.zara.presentation.theme.ZaraTheme
import com.mario.zara.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<MainViewModel>()

        setContent {
            ZaraTheme {
                MainNavHost(viewModel = viewModel)
            }
        }
    }
}
