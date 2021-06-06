package ru.tatarchuk.personaldictionary.di.module

import androidx.core.util.Supplier
import dagger.Module
import dagger.Provides
import ru.tatarchuk.personaldictionary.domain.usecase.dictionary.DictionaryUseCase
import ru.tatarchuk.personaldictionary.domain.usecase.newword.NewWordUseCase
import ru.tatarchuk.personaldictionary.domain.usecase.search.SearchUseCase
import ru.tatarchuk.personaldictionary.domain.usecase.sendnewword.SendNewWordUseCase
import ru.tatarchuk.personaldictionary.domain.usecase.singleword.SingleWordInteractor
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.root.DictionaryViewModel
import ru.tatarchuk.personaldictionary.presentation.newword.NewWordViewModel
import ru.tatarchuk.personaldictionary.presentation.dictionary.chuld.search.SearchViewModel
import ru.tatarchuk.personaldictionary.presentation.viewmodel.*

/**
 * @author tatarchukilya@gmail.com
 */
@Module
object ViewModelFactoryModule {

    @JvmStatic
    @Provides
    fun provideDictionaryViewModel(interactor: DictionaryUseCase):
            ViewModelProviderFactory<DictionaryViewModel> = ViewModelProviderFactory(
        Supplier { return@Supplier DictionaryViewModel(interactor) })

    @JvmStatic
    @Provides
    fun provideSingleWordViewModel(interactor: SingleWordInteractor):
            ViewModelProviderFactory<SingleWordViewModel> =
        ViewModelProviderFactory(Supplier { return@Supplier SingleWordViewModel(interactor) })

    @JvmStatic
    @Provides
    fun provideNewWordViewModel(interactor: NewWordUseCase):
            ViewModelProviderFactory<NewWordViewModel> =
        ViewModelProviderFactory(Supplier { return@Supplier NewWordViewModel(interactor) })

    @JvmStatic
    @Provides
    fun provideSendNewWordViewModel(useCase: SendNewWordUseCase):
            ViewModelProviderFactory<SendNewWordViewModel> =
        ViewModelProviderFactory(Supplier { return@Supplier SendNewWordViewModel(useCase) })

    @JvmStatic
    @Provides
    fun provideSearchViewModelFactory(useCase: SearchUseCase): ViewModelProviderFactory<SearchViewModel> =
        ViewModelProviderFactory(Supplier { return@Supplier SearchViewModel(useCase) })
}