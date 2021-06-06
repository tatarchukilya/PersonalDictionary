package ru.tatarchuk.personaldictionary.data.repo

import kotlinx.coroutines.flow.Flow
import ru.tatarchuk.personaldictionary.data.db.DictionaryDao
import ru.tatarchuk.personaldictionary.data.db.WordEntity
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.AsureTranslateApi
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.DictionaryTranslateApi
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.model.NewWord
import ru.tatarchuk.personaldictionary.data.remote.rest.google.GoogleTranslateApi
import ru.tatarchuk.personaldictionary.data.repo.converter.getTranslate
import ru.tatarchuk.personaldictionary.domain.repo.Repository
import java.util.*

/**
 * @author tatarchukilya@gmail.com
 */
class RepositoryImpl(
    private val dao: DictionaryDao,
    private val googleApi: GoogleTranslateApi,
    private val asureApi: AsureTranslateApi,
    private val dictionary: DictionaryTranslateApi
) : Repository {

    override suspend fun getGoogleTranslation(input: String) = googleApi
        .getTranslation(input)
        .getTranslate()

    override suspend fun getAsureTranslation(input: String) = asureApi
        .getTranslation(input)
        .getTranslate()

    override suspend fun addWord(entity: WordEntity) {
        dao.addWord(entity)
    }

    override suspend fun getWordList(): List<WordEntity> = dao.getDictionary()

    override suspend fun getDictionary(): Flow<String> = dictionary.getTranslation()

    override suspend fun addWord(data: NewWord) = dictionary.addWord(data)

    override suspend fun search(input: String) = dictionary.search(input, 20).result
}