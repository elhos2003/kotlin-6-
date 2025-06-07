package com.example.notes.data.remote

import com.example.notes.domain.model.Note
import kotlinx.coroutines.delay

class NoteRemoteDataSource {
    suspend fun fetchNotes(): List<Note> {
        delay(1000) // Simulate network delay
        return listOf(
            Note("1", "Note 1", "Content 1", true),
            Note("2", "Note 2", "Content 2", true)
        )
    }

    suspend fun deleteNote(uid: String) {
        println("Note $uid deleted from backend (Mock)")
    }
}
