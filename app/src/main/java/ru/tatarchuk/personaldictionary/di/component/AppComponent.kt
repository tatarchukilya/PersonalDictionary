package ru.tatarchuk.personaldictionary.di.component

import dagger.Component
import ru.tatarchuk.personaldictionary.di.module.AppModule
import ru.tatarchuk.personaldictionary.di.module.ViewModelFactoryModule
import ru.tatarchuk.personaldictionary.di.module.db.DataBaseModule
import ru.tatarchuk.personaldictionary.di.module.remote.*
import ru.tatarchuk.personaldictionary.presentation.viewmodel.*
import javax.inject.Singleton

/**
 * @author tatarchukilya@gmail.com
 */
@Singleton
@Component(
    modules = [
        AppModule::class,
        AsureRemoteModule::class,
        DataBaseModule::class,
        FirestoreModule::class,
        GoogleRemoteModule::class,
        RemoteModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent {
    fun getTestViewModelFactory(): ViewModelProviderFactory<TestViewModel>

    fun getDictionaryViewModelFactory(): ViewModelProviderFactory<DictionaryViewModel>

    fun getSingleWordViewModelFactory() : ViewModelProviderFactory<SingleWordViewModel>

    fun getAddWordViewModelFactory() : ViewModelProviderFactory<NewWordViewModel>
}