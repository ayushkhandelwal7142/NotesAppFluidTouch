package com.practice.notesappfluidtouch.presentation.model

data class Items(
    val name: String,
    val resId: Int,
) {
    fun matches(query: String): Boolean {
        return name.contains(other = query, ignoreCase = true)
    }
}
