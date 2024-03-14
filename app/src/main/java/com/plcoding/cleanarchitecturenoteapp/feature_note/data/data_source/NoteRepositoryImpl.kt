package com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao:NoteDao
):NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes()
    }

    override suspend fun addNote(note: Note) {
        return noteDao.addNote(note)
    }

    override suspend fun deleteNote(note: Note) {
       return deleteNote(note)
    }

    override suspend fun getNoteById(id: Int) {
       return getNoteById(id)
    }

}