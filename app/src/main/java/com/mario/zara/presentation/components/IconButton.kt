package com.mario.zara.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.mario.zara.presentation.theme.Spacing
import com.mario.zara.presentation.theme.ZaraTheme
import com.mario.zara.utils.OnClick

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    onClick: OnClick,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = modifier.padding(vertical = Spacing.xs)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ZaraTheme {
        IconButton(
            icon = Icons.Filled.ArrowForward,
            onClick = {}
        )
    }
}
