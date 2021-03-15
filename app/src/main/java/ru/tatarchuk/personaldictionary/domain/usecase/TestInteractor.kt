package ru.tatarchuk.personaldictionary.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.tatarchuk.personaldictionary.data.db.WordEntity
import ru.tatarchuk.personaldictionary.data.remote.firestore.FireStoreWord

/**
 * @author tatarchukilya@gmail.com
 */
interface TestInteractor {

    suspend fun getGoogleTranslations(input: String): Flow<String>

    suspend fun getAsureTranslations(input: String): Flow<String>

    suspend fun getTranslationById(input: String): Flow<FireStoreWord?>

    suspend fun getTranslationByWord(input: String): Flow<FireStoreWord?>

    suspend fun addWord(entity: WordEntity)
}