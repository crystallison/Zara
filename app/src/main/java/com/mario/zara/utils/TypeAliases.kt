package com.mario.zara.utils

import com.mario.zara.domain.models.Character

typealias OnClick = () -> Unit
typealias OnSearchClick = (String) -> Unit
typealias OnPageClick = (Int) -> Unit
typealias OnCharacterClick = (Character) -> Unit
typealias OnValueChange = (String) -> Unit
