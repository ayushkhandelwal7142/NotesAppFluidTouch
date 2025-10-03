package com.practice.notesappfluidtouch.domain

import com.practice.notesappfluidtouch.data.CoversData
import com.practice.notesappfluidtouch.data.PapersData

class HomeDataRepository {
    fun getAllCoversList() = CoversData.allCoversList
    fun getAllPapersList() = PapersData.allPapersList
}