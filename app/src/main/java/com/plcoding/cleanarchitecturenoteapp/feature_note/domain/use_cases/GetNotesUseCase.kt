package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.utils.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.utils.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(private val repository: NoteRepository) {
    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Title(OrderType.ASCENDING)): Flow<List<Note>> {
        val notes = repository.getNotes()
        val orderedNotes = notes.map { notes ->
            when (noteOrder.orderType) {
                OrderType.ASCENDING -> {
                    when (noteOrder) {
                        is NoteOrder.Color -> {
                            notes.sortedBy { it.color }
                        }

                        is NoteOrder.Date -> {
                            notes.sortedBy { it.date }
                        }

                        is NoteOrder.Title -> {
                            notes.sortedBy { it.title }
                        }
                    }
                }

                OrderType.DESCENDING -> {
                    when (noteOrder) {
                        is NoteOrder.Color -> {
                            notes.sortedByDescending { it.color }
                        }
                        is NoteOrder.Date -> {
                            notes.sortedByDescending { it.date }
                        }
                        is NoteOrder.Title -> {
                            notes.sortedByDescending { it.title }
                        }
                    }
                }
            }


        }

        return orderedNotes
    }
}