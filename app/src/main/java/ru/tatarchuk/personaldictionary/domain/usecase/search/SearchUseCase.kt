package ru.tatarchuk.personaldictionary.domain.usecase.search

import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.Word
import ru.tatarchuk.personaldictionary.domain.ResultWrapper

/**
 * @author tatarchukilya@gmail.com
 */
interface SearchUseCase {

    suspend fun search(input: String) : ResultWrapper<List<Word>>
}