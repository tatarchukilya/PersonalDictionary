package ru.tatarchuk.personaldictionary.domain.repo

import kotlinx.coroutines.flow.Flow
import ru.tatarchuk.personaldictionary.data.db.WordEntity
import ru.tatarchuk.personaldictionary.data.remote.firestore.FireStoreWord
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.NewWord
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.Word
import ru.tatarchuk.personaldictionary.data.repo.model.FirestoreModel
import java.util.*

/**
 * @author tatarchukilya@gmail.com
 */
interface Repository {

    suspend fun getGoogleTranslation(input: String): Flow<String>

    suspend fun getAsureTranslation(input: String): Flow<String>

    suspend fun addWord(entity: WordEntity)

    suspend fun getWordList(): List<WordEntity>

    suspend fun getDictionary(): Flow<String>

    suspend fun addWord(data: NewWord): String

    suspend fun search(input: String): List<Word>
}