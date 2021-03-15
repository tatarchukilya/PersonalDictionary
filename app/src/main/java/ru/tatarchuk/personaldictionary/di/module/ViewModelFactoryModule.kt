package ru.tatarchuk.personaldictionary.di.module

import androidx.core.util.Supplier
import dagger.Module
import dagger.Provides
import ru.tatarchuk.personaldictionary.domain.usecase.TestInteractor
import ru.tatarchuk.personaldictionary.domain.usecase.newword.NewWordInteractor
import ru.tatarchuk.personaldictionary.domain.usecase.dictionary.DictionaryUseCase
import ru.tatarchuk.personaldictionary.domain.usecase.singleword.SingleWordInteractor
import ru.tatarchuk.personaldictionary.presentation.viewmodel.*

/**
 * @author tatarchukilya@gmail.com
 */
@Module
object ViewModelFactoryModule {

    @JvmStatic
    @Provides
    fun provideTestViewModelFactory(interactor: TestInteractor):
            ViewModelProviderFactory<TestViewModel> {
        return ViewModelProviderFactory(
            Supplier { return@Supplier TestViewModel(interactor) },
//            Consumer { viewModel -> viewModel.loadLocalDictionary() }
        )
    }

    @JvmStatic
    @Provides
    fun provideDictionaryViewModel(interactor: DictionaryUseCase):
            ViewModelProviderFactory<DictionaryViewModel> = ViewModelProviderFactory(
        Supplier { return@Supplier DictionaryViewModel(interactor) },
        { viewModel -> viewModel.getWordList() })

    @JvmStatic
    @Provides
    fun provideSingleWordViewModel(interactor: SingleWordInteractor):
            ViewModelProviderFactory<SingleWordViewModel> =
        ViewModelProviderFactory(Supplier { return@Supplier SingleWordViewModel(interactor) })

    @JvmStatic
    @Provides
    fun provideNewWordViewModel(interactor: NewWordInteractor):
            ViewModelProviderFactory<NewWordViewModel> =
        ViewModelProviderFactory(Supplier { return@Supplier NewWordViewModel(interactor) })
}