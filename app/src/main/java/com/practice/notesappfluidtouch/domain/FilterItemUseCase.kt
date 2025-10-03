package com.practice.notesappfluidtouch.domain

import com.practice.notesappfluidtouch.presentation.model.Items

class FilterItemsUseCase {
    operator fun invoke(query: String, list: List<Items>?): List<Items> {
        if (query.isBlank()) return list.orEmpty()
        return list.orEmpty().filter { it.matches(query) }
    }
}