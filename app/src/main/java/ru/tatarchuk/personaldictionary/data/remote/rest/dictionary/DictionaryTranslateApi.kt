package ru.tatarchuk.personaldictionary.data.remote.rest.dictionary

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.NewWord
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.SearchResponse

/**
 * @author tatarchukilya@gmail.com
 */
interface DictionaryTranslateApi {

    suspend fun getTranslation(): Flow<String>

    suspend fun addWord(data: NewWord): String

    suspend fun search(input: String, limit: Int = 10) : SearchResponse

}