package ru.tatarchuk.personaldictionary.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.tatarchuk.personaldictionary.DictionaryApp
import ru.tatarchuk.personaldictionary.data.db.DictionaryDao
import ru.tatarchuk.personaldictionary.data.remote.firestore.FireStoreApi
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.AsureTranslateApi
import ru.tatarchuk.personaldictionary.data.remote.rest.google.GoogleTranslateApi
import ru.tatarchuk.personaldictionary.data.repo.RepositoryImpl
import ru.tatarchuk.personaldictionary.domain.usecase.TestInteractor
import ru.tatarchuk.personaldictionary.domain.usecase.TestInteractorImpl
import ru.tatarchuk.personaldictionary.domain.usecase.newword.NewWordInteractor
import ru.tatarchuk.personaldictionary.domain.usecase.newword.NewWordInteractorImpl
import ru.tatarchuk.personaldictionary.domain.usecase.dictionary.DictionaryUseCase
import ru.tatarchuk.personaldictionary.domain.usecase.dictionary.DictionaryInteractorImpl
import ru.tatarchuk.personaldictionary.domain.usecase.singleword.SingleWordInteractor
import ru.tatarchuk.personaldictionary.domain.usecase.singleword.SingleWordInteractorImpl
import ru.tatarchuk.personaldictionary.domain.repo.Repository
import javax.inject.Singleton

/**
 * @author tatarchukilya@gmail.com
 */
@Module
class AppModule(private val application: DictionaryApp) {

    @Provides
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideRepository(
        dao: DictionaryDao,
        fireStoreApi: FireStoreApi,
        googleApi: GoogleTranslateApi,
        asureApi: AsureTranslateApi
    ): Repository =
        RepositoryImpl(
            dao,
            fireStoreApi,
            googleApi,
            asureApi
        )

    @Provides
    @Singleton
    fun provideTestInteractor(repository: Repository): TestInteractor =
        TestInteractorImpl(repository)

    @Provides
    @Singleton
    fun provideDictionaryInteractor(repository: Repository): DictionaryUseCase =
        DictionaryInteractorImpl(repository)

    @Provides
    @Singleton
    fun provideSingleWordInteractor(repository: Repository): SingleWordInteractor =
        SingleWordInteractorImpl(repository)

    @Provides
    @Singleton
    fun provideNewWordInteractor(repository: Repository): NewWordInteractor =
        NewWordInteractorImpl(repository)
}