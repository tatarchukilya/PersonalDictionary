package ru.tatarchuk.personaldictionary.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.tatarchuk.personaldictionary.DictionaryApp
import ru.tatarchuk.personaldictionary.data.db.DictionaryDao
import ru.tatarchuk.personaldictionary.data.remote.rest.asure.AsureTranslateApi
import ru.tatarchuk.personaldictionary.data.remote.rest.dictionary.DictionaryTranslateApi
import ru.tatarchuk.personaldictionary.data.remote.rest.google.GoogleTranslateApi
import ru.tatarchuk.personaldictionary.data.repo.RepositoryImpl
import ru.tatarchuk.personaldictionary.domain.repo.Repository
import ru.tatarchuk.personaldictionary.domain.usecase.dictionary.DictionaryInteractorImpl
import ru.tatarchuk.personaldictionary.domain.usecase.dictionary.DictionaryUseCase
import ru.tatarchuk.personaldictionary.domain.usecase.newword.NewWordUseCase
import ru.tatarchuk.personaldictionary.domain.usecase.newword.NewWordUseCaseImpl
import ru.tatarchuk.personaldictionary.domain.usecase.search.SearchUseCase
import ru.tatarchuk.personaldictionary.domain.usecase.search.SearchUseCaseImpl
import ru.tatarchuk.personaldictionary.domain.usecase.sendnewword.SendNewWordUseCase
import ru.tatarchuk.personaldictionary.domain.usecase.sendnewword.SendNewWordUseCaseImpl
import ru.tatarchuk.personaldictionary.domain.usecase.singleword.SingleWordInteractor
import ru.tatarchuk.personaldictionary.domain.usecase.singleword.SingleWordInteractorImpl
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
        googleApi: GoogleTranslateApi,
        asureApi: AsureTranslateApi,
        dictionaryTranslateApi: DictionaryTranslateApi
    ): Repository =
        RepositoryImpl(
            dao,
            googleApi,
            asureApi,
            dictionaryTranslateApi
        )

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
    fun provideNewWordInteractor(repository: Repository): NewWordUseCase =
        NewWordUseCaseImpl(repository)

    @Provides
    @Singleton
    fun provideNewWordUseCase(repository: Repository): SendNewWordUseCase =
        SendNewWordUseCaseImpl(repository)

    @Provides
    @Singleton
    fun provideSearchUseCase(repository: Repository): SearchUseCase =
        SearchUseCaseImpl(repository)
}