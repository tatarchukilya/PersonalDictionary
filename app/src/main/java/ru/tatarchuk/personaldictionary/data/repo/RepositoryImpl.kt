package ru.tatarchuk.personaldictionary.data.repo

import ru.tatarchuk.personaldictionary.data.db.DictionaryDao
import ru.tatarchuk.personaldictionary.data.db.WordEntity
import ru.tatarchuk.personaldictionary.data.remote.firestore.FireStoreApi
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.AsureTranslateApi
import ru.tatarchuk.personaldictionary.data.remote.rest.google.GoogleTranslateApi
import ru.tatarchuk.personaldictionary.data.repo.converter.getTranslate
import ru.tatarchuk.personaldictionary.data.repo.converter.toFirestoreWord
import ru.tatarchuk.personaldictionary.data.repo.converter.toWord
import ru.tatarchuk.personaldictionary.domain.repo.Repository

/**
 * @author tatarchukilya@gmail.com
 */
class RepositoryImpl(
    private val dao: DictionaryDao,
    private val firestoreApi: FireStoreApi,
    private val googleApi: GoogleTranslateApi,
    private val asureApi: AsureTranslateApi,
) : Repository {

    override suspend fun getGoogleTranslation(input: String) = googleApi
        .getTranslation(input)
        .getTranslate()

    override suspend fun getAsureTranslation(input: String) = asureApi
        .getTranslation(input)
        .getTranslate()

    override suspend fun getTranslationById(input: String) =
        firestoreApi.getFlowWordById(input)

    override suspend fun getTranslationByWord(input: String) =
        firestoreApi.getFlowWord(input).toWord()

    override suspend fun getFirestoreWord(id: String) =
        firestoreApi.getWordById(id).toFirestoreWord()

    override suspend fun addWord(entity: WordEntity) {
        dao.addWord(entity)
    }

    override suspend fun getWordList(): List<WordEntity> = dao.getDictionary()
}