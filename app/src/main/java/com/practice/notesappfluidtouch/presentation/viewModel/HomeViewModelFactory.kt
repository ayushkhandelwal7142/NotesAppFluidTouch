package com.practice.notesappfluidtouch.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.notesappfluidtouch.domain.FilterItemsUseCase
import com.practice.notesappfluidtouch.domain.HomeDataRepository

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(
    private val homeDataRepository: HomeDataRepository,
    private val filterItemsUseCase: FilterItemsUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(
                homeDataRepository = homeDataRepository,
                filterItemUseCase = filterItemsUseCase,
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}