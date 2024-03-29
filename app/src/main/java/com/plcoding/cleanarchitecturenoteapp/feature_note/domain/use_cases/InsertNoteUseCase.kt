package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class InsertNoteUseCase(
    private val repository: NoteRepository
) {
   suspend operator fun invoke(note: Note) {
        repository.addNote(note)
    }
}