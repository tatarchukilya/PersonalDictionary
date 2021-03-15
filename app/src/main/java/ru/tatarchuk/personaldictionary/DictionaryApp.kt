package ru.tatarchuk.personaldictionary

import android.app.Application
import ru.tatarchuk.personaldictionary.di.component.AppComponent
import ru.tatarchuk.personaldictionary.di.component.DaggerAppComponent
import ru.tatarchuk.personaldictionary.di.module.AppModule

/**
 * @author tatarchukilya@gmail.com
 */
class DictionaryApp : Application() {

    val appComponent: AppComponent = DaggerAppComponent
        .builder()
        .appModule(AppModule(this))
        .build()
}