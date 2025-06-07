package com.example.notes.data.local

import com.example.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class NoteLocalDataSource {
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notesFlow: Flow<List<Note>> = _notes

    suspend fun saveNote(note: Note) {
        _notes.update { currentNotes -> currentNotes + note }
    }

    suspend fun deleteNote(uid: String) {
        _notes.update { currentNotes -> currentNotes.filter { it.uid != uid } }
    }
}
