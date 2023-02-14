package com.mario.zara.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mario.zara.R
import com.mario.zara.presentation.theme.Spacing

@Composable
internal fun LoadingDataScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.loading_data),
            style = MaterialTheme.typography.h5
        )
        Spacer(Modifier.height(Spacing.l))
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    LoadingDataScreen()
}
