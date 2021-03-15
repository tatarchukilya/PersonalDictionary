package ru.tatarchuk.personaldictionary.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

/**
 * @author tatarchukilya@gmail.com
 */
@Dao
abstract class DictionaryDao {

    @Query("SELECT * FROM dictionary")
    abstract suspend fun getDictionary(): List<WordEntity>

    @Insert(onConflict = REPLACE)
    abstract suspend fun addWord(wordEntity: WordEntity?)

    @Query("DELETE FROM dictionary WHERE word = :word")
    abstract suspend fun deleteWord(word: String)
}