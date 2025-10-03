package com.practice.notesappfluidtouch.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.notesappfluidtouch.presentation.model.Items

@Composable
fun ItemRowView(
    title: String,
    items: List<Items>,
) {
    Column {
        if (items.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, top = 14.dp, bottom = 8.dp),
                text = title,
                fontSize = 24.sp
            )
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items) { item ->
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    ItemCardView(imageRes = item.resId)
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = item.name,
                    )
                }
            }
        }
    }
}