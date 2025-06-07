package com.example.notes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.model.Note
import com.example.notes.domain.usecase.DeleteNoteUseCase
import com.example.notes.domain.usecase.GetNotesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoteViewModel(
    private val getNotesUseCase: GetNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {
    private val _notesState = MutableStateFlow<List<Note>>(emptyList())
    val notesState: StateFlow<List<Note>> = _notesState

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch {
            getNotesUseCase().collect { notes ->
                _notesState.value = notes
            }
        }
    }

    fun deleteNote(uid: String) {
        viewModelScope.launch {
            deleteNoteUseCase(uid)
        }
    }
}
