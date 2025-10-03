package com.practice.notesappfluidtouch.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.practice.notesappfluidtouch.domain.FilterItemsUseCase
import com.practice.notesappfluidtouch.domain.HomeDataRepository
import com.practice.notesappfluidtouch.presentation.viewModel.HomeViewModel
import com.practice.notesappfluidtouch.presentation.viewModel.HomeViewModelFactory
import com.practice.notesappfluidtouch.ui.theme.NotesAppFluidTouchTheme

class MainActivity : ComponentActivity() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeDataRepository: HomeDataRepository
    private lateinit var filterItemsUseCase: FilterItemsUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeDataRepository = HomeDataRepository()
        filterItemsUseCase = FilterItemsUseCase()
        homeViewModel = ViewModelProvider(
            owner = this,
            factory = HomeViewModelFactory(
                homeDataRepository = homeDataRepository,
                filterItemsUseCase = filterItemsUseCase,
            )
        )[HomeViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            NotesAppFluidTouchTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.Companion.padding(paddingValues = innerPadding),
                        viewModel = homeViewModel,
                    )
                }
            }
        }
    }
}