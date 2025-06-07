package com.example.notes.domain.model

data class Note(
    val uid: String,
    val title: String,
    val content: String,
    val isSynced: Boolean = false
)
