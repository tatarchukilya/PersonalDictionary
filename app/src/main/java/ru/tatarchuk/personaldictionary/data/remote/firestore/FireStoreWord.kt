package ru.tatarchuk.personaldictionary.data.remote.firestore

/**
 * @author tatarchukilya@gmail.com
 */
data class FireStoreWord(
    var word: String,
    var transcription: String = "",
    var translation: List<String> = listOf(),
    var example: List<String> = listOf(),
)
