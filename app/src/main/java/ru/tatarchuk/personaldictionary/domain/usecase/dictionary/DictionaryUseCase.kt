package ru.tatarchuk.personaldictionary.domain.usecase.dictionary

import ru.tatarchuk.personaldictionary.data.db.WordEntity

/**
 * @author tatarchukilya@gmail.com
 */
interface DictionaryUseCase {

    suspend fun getWordList(): List<WordEntity>
}