package ru.tatarchuk.personaldictionary.di.module.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.tatarchuk.personaldictionary.data.db.DictionaryDao
import ru.tatarchuk.personaldictionary.data.db.DictionaryDataBase
import javax.inject.Singleton

/**
 * @author tatarchukilya@gmail.com
 */
@Module
object DataBaseModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideDb(context: Context): DictionaryDataBase = Room
        .databaseBuilder(context, DictionaryDataBase::class.java, "dictionary_db")
        .build()

    @JvmStatic
    @Provides
    @Singleton
    fun provideDao(dataBase: DictionaryDataBase): DictionaryDao = dataBase.dictionaryDao()
}