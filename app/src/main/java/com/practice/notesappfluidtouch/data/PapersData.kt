package com.practice.notesappfluidtouch.data

import com.practice.notesappfluidtouch.R
import com.practice.notesappfluidtouch.presentation.model.Items

object PapersData {
    val allPapersList = listOf(
        Items(name = "Paper1", resId = R.raw.lesson_planner),
        Items(name = "Paper2", resId = R.raw.assignment_tracker),
        Items(name = "Paper3", resId = R.raw.legend_books),
        Items(name = "Paper4", resId = R.raw.weekly_planner),
    )
}