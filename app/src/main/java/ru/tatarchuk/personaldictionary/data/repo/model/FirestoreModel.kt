package ru.tatarchuk.personaldictionary.data.repo.model

/**
 * @author tatarchukilya@gmail.com
 */
data class FirestoreModel(
    val word: String,
    val transcription: String,
    val translation: List<String>,
    val example: List<String>
)
