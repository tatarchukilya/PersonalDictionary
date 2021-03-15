package ru.tatarchuk.personaldictionary.domain.usecase.newword

import ru.tatarchuk.personaldictionary.domain.repo.Repository

/**
 * @author tatarchukilya@gmail.com
 */
class NewWordInteractorImpl(private val repository: Repository) : NewWordInteractor {

    override suspend fun getTranslationByWord(input: String) = repository
        .getTranslationByWord(input)

    override suspend fun getWordData(id: String) = repository.getFirestoreWord(id)
}