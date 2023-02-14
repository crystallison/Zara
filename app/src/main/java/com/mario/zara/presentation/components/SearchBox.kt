package com.mario.zara.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mario.zara.presentation.theme.ZaraTheme
import com.mario.zara.utils.OnSearchClick
import com.mario.zara.utils.OnValueChange

@Composable
internal fun SearchBox(
    modifier: Modifier = Modifier,
    hint: String = "",
    value: String,
    isEnabled: Boolean = true,
    onValueChange: OnValueChange,
    onSearchClick: OnSearchClick
) {
    OutlinedTextField(
        modifier = modifier,
        hint = hint,
        value = value,
        isEnabled = isEnabled,
        onValueChange = onValueChange,
        onActionClick = onSearchClick
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ZaraTheme {
        SearchBox(
            hint = "Hint text",
            value = "123",
            onValueChange = {},
            onSearchClick = {}
        )
    }
}
