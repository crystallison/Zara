package com.mario.zara.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.mario.zara.presentation.theme.Spacing
import com.mario.zara.presentation.theme.ZaraTheme
import com.mario.zara.utils.OnSearchClick

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun OutlinedTextField(
    modifier: Modifier = Modifier,
    hint: String,
    value: String,
    isEnabled: Boolean = true,
    onValueChange: (String) -> Unit,
    onActionClick: OnSearchClick
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = modifier.focusRequester(focusRequester),
        value = value,
        enabled = isEnabled,
        onValueChange = onValueChange,
        label = { Text(hint) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        singleLine = true,
        shape = RoundedCornerShape(Spacing.s),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = MaterialTheme.colors.primary,
            unfocusedLabelColor = Color.LightGray,
            textColor = Color.DarkGray
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onActionClick.invoke(value)
                focusManager.clearFocus()
                keyboardController?.hide()
            }
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ZaraTheme {
        OutlinedTextField(
            hint = "Hint text",
            value = "123",
            onValueChange = {},
            onActionClick = {}
        )
    }
}
