package ru.tatarchuk.personaldictionary.domain.usecase.newword

import kotlinx.coroutines.flow.Flow
import ru.tatarchuk.personaldictionary.domain.repo.Repository

/**
 * @author tatarchukilya@gmail.com
 */
class NewWordUseCaseImpl(private val repository: Repository) : NewWordUseCase {

    override suspend fun getDictionary(): Flow<String> = repository.getDictionary()
}