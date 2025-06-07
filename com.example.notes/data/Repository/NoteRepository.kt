package com.example.notes.data.repository

import com.example.notes.data.local.NoteLocalDataSource
import com.example.notes.data.remote.NoteRemoteDataSource
import com.example.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NoteRepository(
    private val localDataSource: NoteLocalDataSource,
    private val remoteDataSource: NoteRemoteDataSource
) {
    fun getNotes(): Flow<List<Note>> = flow {
        emit(localDataSource.notesFlow.first())

        val remoteNotes = remoteDataSource.fetchNotes()
        remoteNotes.forEach { note ->
            localDataSource.saveNote(note)
        }
        emit(localDataSource.notesFlow.first())
    }

    suspend fun deleteNote(uid: String) {
        localDataSource.deleteNote(uid)
        remoteDataSource.deleteNote(uid)
    }
}
