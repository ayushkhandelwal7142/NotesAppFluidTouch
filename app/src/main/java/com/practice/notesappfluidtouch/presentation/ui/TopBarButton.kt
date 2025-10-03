package com.practice.notesappfluidtouch.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.practice.notesappfluidtouch.R

@Composable
fun TopBarButton(
    onAddCLick: () -> Unit,
    onSearchClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
    ) {
        Button(
            onClick = { onAddCLick() }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_add),
                contentDescription = "Add Icon"
            )
        }

        Spacer(modifier = Modifier.padding(horizontal = 4.dp))

        Button(
            onClick = { onSearchClick() }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Add Icon"
            )
        }
    }
}