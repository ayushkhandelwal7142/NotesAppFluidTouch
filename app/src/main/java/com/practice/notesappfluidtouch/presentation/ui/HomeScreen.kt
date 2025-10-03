package com.practice.notesappfluidtouch.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.notesappfluidtouch.presentation.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier,
    viewModel: HomeViewModel,
) {
    val coversList by viewModel.filteredCovers.collectAsState()
    val papersList by viewModel.filteredPapers.collectAsState()
    val showAddItemPopUp by viewModel.showAddItemPopUp.collectAsState()
    val isSearchActive by viewModel.isSearchActive.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val allCoversList = viewModel.getAllCoversList()
    val allPapersList = viewModel.getAllPapersList()

    Box(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column {
            if (isSearchActive) {
                SearchBar(
                    query = searchQuery,
                    onQueryChange = { viewModel.updateSearchQuery(it) },
                    onClose = { viewModel.closeSearch() }
                )
            } else {
                TopBarButton(
                    onAddCLick = { viewModel.onAddClick() },
                    onSearchClick = { viewModel.onSearchClick() }
                )
            }

            HomeTitle()

            ItemRowView(
                title = "Covers",
                items = coversList,
            )

            ItemRowView(
                title = "Papers",
                items = papersList,
            )
        }
    }

    AddItemDialog(
        showDialog = showAddItemPopUp,
        covers = allCoversList,
        papers = allPapersList,
        dismissDialog = { viewModel.dismissDialog() },
        onSelectCover = { viewModel.updateCoversList(item = it) },
        onSelectPaper = { viewModel.updatePapersList(item = it) }
    )
}

@Composable
fun HomeTitle() {
    Text(
        modifier = Modifier
            .padding(8.dp),
        text = "Home",
        fontSize = 30.sp,
    )
}