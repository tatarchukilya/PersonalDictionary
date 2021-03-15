package ru.tatarchuk.personaldictionary.domain.repo

import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.coroutines.flow.Flow
import ru.tatarchuk.personaldictionary.data.db.WordEntity
import ru.tatarchuk.personaldictionary.data.remote.firestore.FireStoreWord
import ru.tatarchuk.personaldictionary.data.repo.model.FirestoreModel

/**
 * @author tatarchukilya@gmail.com
 */
interface Repository {

    suspend fun getGoogleTranslation(input: String): Flow<String>

    suspend fun getAsureTranslation(input: String): Flow<String>

    suspend fun getTranslationById(input: String): Flow<FireStoreWord?>

    suspend fun getTranslationByWord(input: String): Flow<FireStoreWord?>

    suspend fun getFirestoreWord(id: String): FirestoreModel

    suspend fun addWord(entity: WordEntity)

    suspend fun getWordList(): List<WordEntity>
}