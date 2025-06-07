class NoteLocalDataSource {
    private val notesCache = mutableListOf<Note>()

    private val _notesFlow = MutableStateFlow<List<Note>>(emptyList())
    val notesFlow: StateFlow<List<Note>> = _notesFlow.asStateFlow()

    suspend fun saveNote(note: Note) {
        notesCache.add(note)
        _notesFlow.emit(notesCache) // إ UI 
    }

    suspend fun deleteNote(uid: String) {
        notesCache.removeAll { it.uid == uid }
        _notesFlow.emit(notesCache)
    }

    fun getNotes(): Flow<List<Note>> = notesFlow
}
