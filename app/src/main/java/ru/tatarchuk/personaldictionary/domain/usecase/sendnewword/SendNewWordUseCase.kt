package ru.tatarchuk.personaldictionary.domain.usecase.sendnewword

import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.NewWord
import ru.tatarchuk.personaldictionary.domain.ResultWrapper

/**
 * @author tatarchukilya@gmail.com
 */
interface SendNewWordUseCase {

    suspend fun addWord(data: NewWord) : ResultWrapper<String>
}