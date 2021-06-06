package ru.tatarchuk.personaldictionary.data.repo.converter

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import ru.tatarchuk.personaldictionary.data.remote.firestore.FireStoreWord
import ru.tatarchuk.personaldictionary.data.remote.rest.google.model.GoogleBody
import ru.tatarchuk.personaldictionary.data.repo.model.FirestoreModel

/**
 * @author tatarchukilya@gmail.com
 */

fun Flow<QuerySnapshot>.toWord() = flow {
    collect {
        emit(it.documents[0].data?.toWord())
    }
}

fun Map<String, Any>.toWord(): FireStoreWord {
    val word = get("word") as String
    val transcription = get("transcription") as String
    val translation = get("translation") as List<String>
    return FireStoreWord(word, transcription, translation)
}

fun Flow<GoogleBody>.getTranslate() = flow {
    collect {
        emit(it.data.translations[0].translatedText)
    }
}

@Suppress("UNCHECKED_CAST")
fun DocumentSnapshot.toFirestoreWord() = FirestoreModel(
    data?.get("word") as String,
    data?.get("transcription") as String,
    (data?.get("translation") as List<String>?) ?: emptyList(),
    (data?.get("example") as List<String>?) ?: emptyList()
)

