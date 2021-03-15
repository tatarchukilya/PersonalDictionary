package ru.tatarchuk.personaldictionary.data.remote.firestore

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.flow.Flow

/**
 * @author tatarchukilya@gmail.com
 */
interface FireStoreApi {

    suspend fun getFlowWord(input: String): Flow<QuerySnapshot>

    suspend fun getFlowWordById(id: String): Flow<FireStoreWord?>

    suspend fun setWord(pair: Pair<Int, FireStoreWord>): Flow<Pair<Int, FireStoreWord>>

    suspend fun getWordById(id: String): DocumentSnapshot
}