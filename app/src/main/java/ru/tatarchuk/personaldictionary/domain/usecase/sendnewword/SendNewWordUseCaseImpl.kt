package ru.tatarchuk.personaldictionary.domain.usecase.sendnewword

import android.util.Log
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.NewWord
import ru.tatarchuk.personaldictionary.domain.ResultWrapper
import ru.tatarchuk.personaldictionary.domain.repo.Repository
import ru.tatarchuk.personaldictionary.utils.TAG

/**
 * @author tatarchukilya@gmail.com
 */
class SendNewWordUseCaseImpl(private val repository: Repository) : SendNewWordUseCase {

    override suspend fun addWord(data: NewWord): ResultWrapper<String> {
        return try {
            val response = repository.addWord(data)
            return ResultWrapper.Success(response)
        } catch (e: Exception) {
            Log.i(TAG, e.toString(), e)
            ResultWrapper.Error(Pair(R.string.error, R.string.insufficient_data))
        }
    }
}