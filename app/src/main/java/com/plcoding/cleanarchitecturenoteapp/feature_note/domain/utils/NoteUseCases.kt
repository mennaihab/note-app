package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.utils

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.GetNotesUseCase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.InsertNoteUseCase

data class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val insertNoteUseCase: InsertNoteUseCase
)