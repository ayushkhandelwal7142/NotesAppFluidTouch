package com.practice.notesappfluidtouch.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.notesappfluidtouch.domain.FilterItemsUseCase
import com.practice.notesappfluidtouch.domain.HomeDataRepository
import com.practice.notesappfluidtouch.presentation.model.Items
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val homeDataRepository: HomeDataRepository,
    private val filterItemUseCase: FilterItemsUseCase,
) : ViewModel() {
    private val _coversList = MutableStateFlow<List<Items>?>(null)
    val coversList = _coversList.asStateFlow()

    private val _papersList = MutableStateFlow<List<Items>?>(null)
    val papersList = _papersList.asStateFlow()

    private val _showAddItemPopUp = MutableStateFlow(false)
    val showAddItemPopUp = _showAddItemPopUp.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _isSearchActive = MutableStateFlow(false)
    val isSearchActive = _isSearchActive.asStateFlow()

    val filteredCovers = searchQuery.combine(coversList) { query, list ->
        filterItemUseCase.invoke(
            query = query,
            list = list,
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val filteredPapers = searchQuery.combine(papersList) { query, list ->
        filterItemUseCase.invoke(
            query = query,
            list = list
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun getAllCoversList() = homeDataRepository.getAllCoversList()

    fun getAllPapersList() = homeDataRepository.getAllPapersList()

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun closeSearch() {
        _searchQuery.value = ""
        _isSearchActive.value = false
    }

    fun dismissDialog() = _showAddItemPopUp.update { false }

    fun updateCoversList(item: Items) = _coversList.update { it.orEmpty() + item }

    fun updatePapersList(item: Items) = _papersList.update { it.orEmpty() + item }

    fun onAddClick() = _showAddItemPopUp.update { true }

    fun onSearchClick() = _isSearchActive.update { true }
}