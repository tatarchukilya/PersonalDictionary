package ru.tatarchuk.personaldictionary.domain.usecase.newword

import kotlinx.coroutines.flow.Flow
import ru.tatarchuk.personaldictionary.data.remote.firestore.FireStoreWord
import ru.tatarchuk.personaldictionary.data.repo.model.FirestoreModel

/**
 * @author tatarchukilya@gmail.com
 */
interface NewWordUseCase {

    suspend fun getDictionary() : Flow<String>
}