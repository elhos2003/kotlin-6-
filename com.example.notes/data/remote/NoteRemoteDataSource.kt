package com.example.notes.data.remote

import com.example.notes.domain.model.Note
import kotlinx.coroutines.delay

class NoteRemoteDataSource {
    suspend fun fetchNotes(): List<Note> {
        delay(1000) // محاكاة اتصال شبكة
        return listOf(
            Note("1", "ملاحظة 1", "محتوى 1", true),
            Note("2", "ملاحظة 2", "محتوى 2", true)
        )
    }

    suspend fun deleteNote(uid: String) {
        println("تم حذف الملاحظة $uid من البيكند (وهمي)")
    }
}
