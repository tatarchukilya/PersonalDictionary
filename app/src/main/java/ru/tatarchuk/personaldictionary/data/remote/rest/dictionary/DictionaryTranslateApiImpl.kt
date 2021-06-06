package ru.tatarchuk.personaldictionary.data.remote.rest.dictionary

import kotlinx.coroutines.flow.flow
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.NewWord

/**
 * @author tatarchukilya@gmail.com
 */
class DictionaryTranslateApiImpl(private val api: DictionaryRetrofitApi) : DictionaryTranslateApi {

    override suspend fun getTranslation() = flow {
        emit(api.getTranslation())
    }

    override suspend fun addWord(data: NewWord) =
        api.addWord(data)

    override suspend fun search(input: String, limit: Int) = api.search(input, limit)

}