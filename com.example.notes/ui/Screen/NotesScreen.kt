package com.example.notes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notes.ui.viewmodel.NoteViewModel

@Composable
fun NotesScreen(viewModel: NoteViewModel = viewModel()) {
    val notes by viewModel.notesState.collectAsState()

    Column {
        if (notes.isEmpty()) {
            Text("No notes available")
        } else {
            LazyColumn {
                items(notes) { note ->
                    Text(note.title)
                    Text(note.content)
                    Button(onClick = { viewModel.deleteNote(note.uid) }) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}
