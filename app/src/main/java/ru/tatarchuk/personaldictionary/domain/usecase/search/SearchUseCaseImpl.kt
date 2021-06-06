package ru.tatarchuk.personaldictionary.domain.usecase.search

import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.Word
import ru.tatarchuk.personaldictionary.domain.ResultWrapper
import ru.tatarchuk.personaldictionary.domain.repo.Repository

/**
 * @author tatarchukilya@gmail.com
 */
class SearchUseCaseImpl(private val repository: Repository) : SearchUseCase {

    override suspend fun search(input: String): ResultWrapper<List<Word>> {
        return try {
            val  result = repository.search(input)
            return ResultWrapper.Success(result)
        } catch (e : Exception) {
            ResultWrapper.Error(Pair(R.string.error, R.string.insufficient_data))
        }
    }
}