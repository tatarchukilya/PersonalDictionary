package ru.tatarchuk.personaldictionary.domain.usecase

import ru.tatarchuk.personaldictionary.data.db.WordEntity
import ru.tatarchuk.personaldictionary.domain.repo.Repository

/**
 * @author tatarchukilya@gmail.com
 */
class TestInteractorImpl(private val repository: Repository) : TestInteractor {

    override suspend fun getGoogleTranslations(input: String) = repository
        .getGoogleTranslation(input)
        .capitalize()

    override suspend fun getAsureTranslations(input: String) = repository
        .getAsureTranslation(input)
        .capitalize()

    override suspend fun getTranslationById(input: String) = repository
        .getTranslationById(input)

    override suspend fun getTranslationByWord(input: String) = repository
        .getTranslationByWord(input)

    override suspend fun addWord(entity: WordEntity) {
        repository.addWord(entity)
    }
}