package ru.tatarchuk.personaldictionary.data.remote.firestore

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.util.*

/**
 * @author tatarchukilya@gmail.com
 */
class FireStoreApiImpl(private val collection: CollectionReference) : FireStoreApi {

    override suspend fun getFlowWord(input: String) = flow {
        val snapshot = collection.whereEqualTo("word", input).get().await()
        emit(snapshot)
    }

    override suspend fun getFlowWordById(id: String) = flow {
        val snapshot = collection.document(id).get().await()
        val word = snapshot.toObject(FireStoreWord::class.java)
        emit(word)
    }

    override suspend fun setWord(pair: Pair<Int, FireStoreWord>) = flow {
        val key = pair.second.word.toLowerCase(Locale.getDefault())
        collection.document(key).set(
            mapOf(
                "word" to key,
                "transcription" to pair.second.transcription,
                "translation" to pair.second.translation
            )
        ).await()
        //  Log.i(TAG, "${pair.first} setWord: ${pair.second}")
        emit(pair)
    }

    override suspend fun getWordById(id: String): DocumentSnapshot =
        collection.document(id).get().await()
}