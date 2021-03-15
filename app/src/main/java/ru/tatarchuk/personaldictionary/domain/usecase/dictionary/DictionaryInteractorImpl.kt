package ru.tatarchuk.personaldictionary.domain.usecase.dictionary

import ru.tatarchuk.personaldictionary.domain.repo.Repository

/**
 * @author tatarchukilya@gmail.com
 */
class DictionaryInteractorImpl(private val repository: Repository) : DictionaryUseCase {

    override suspend fun getWordList() = repository.getWordList()
}