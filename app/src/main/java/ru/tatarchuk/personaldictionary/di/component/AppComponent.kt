package ru.tatarchuk.personaldictionary.di.component

import dagger.Component
import ru.tatarchuk.personaldictionary.di.api.ViewModelApi
import ru.tatarchuk.personaldictionary.di.module.AppModule
import ru.tatarchuk.personaldictionary.di.module.ViewModelFactoryModule
import ru.tatarchuk.personaldictionary.di.module.db.DataBaseModule
import ru.tatarchuk.personaldictionary.di.module.remote.*
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
        DictionaryModule::class,
        GoogleRemoteModule::class,
        RemoteModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent : ViewModelApi