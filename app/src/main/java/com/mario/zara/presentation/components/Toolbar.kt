package com.mario.zara.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mario.zara.presentation.theme.ZaraTheme
import com.mario.zara.utils.OnClick

@Composable
internal fun Toolbar(
    text: String = "",
    actions: @Composable RowScope.() -> Unit = {},
    onBackClick: OnClick
) {
    TopAppBar(
        title = {
            Text(
                text = text,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Start,
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                )
            }
        },
        actions = actions,
        backgroundColor = Color.Transparent,
        contentColor = Color.DarkGray,
        elevation = 0.dp
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ZaraTheme {
        Toolbar(text = "Lorem Ipsum") {}
    }
}
