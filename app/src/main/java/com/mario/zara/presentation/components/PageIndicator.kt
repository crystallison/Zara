package com.mario.zara.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mario.zara.presentation.theme.Spacing
import com.mario.zara.utils.OnPageClick

@Composable
internal fun PageIndicator(
    currentPage: Int,
    maxPages: Long,
    onPageClick: OnPageClick
) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(Spacing.s)) {
        items(
            count = maxPages.toInt(),
            itemContent = { index ->
                PageIndicator(
                    index = index,
                    isSelected = index == currentPage,
                    onPageClick = onPageClick
                )
            }
        )
    }
}

@Composable
private fun PageIndicator(
    index: Int,
    isSelected: Boolean,
    onPageClick: OnPageClick
) {
    Column(
        modifier = Modifier
            .size(Spacing.xxl)
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.medium
            )
            .clip(shape = MaterialTheme.shapes.medium)
            .background(if (isSelected) MaterialTheme.colors.primaryVariant else Color.Transparent)
            .clickable { onPageClick(index) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = (index + 1).toString(),
            style = MaterialTheme.typography.body1,
            color = if (isSelected) Color.White else MaterialTheme.colors.primaryVariant
        )
    }
}
