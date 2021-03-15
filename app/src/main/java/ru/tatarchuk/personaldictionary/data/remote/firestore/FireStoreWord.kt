package ru.tatarchuk.personaldictionary.data.remote.firestore

import java.util.*

/**
 * @author tatarchukilya@gmail.com
 */
data class FireStoreWord(
    var transcription: String = "",
    var translation: List<String> = Collections.emptyList(),
    var word: String = ""
)
