package ru.tatarchuk.personaldictionary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author tatarchukilya@gmail.com
 */
@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
public abstract class DictionaryDataBase : RoomDatabase() {
    public abstract fun dictionaryDao(): DictionaryDao
}