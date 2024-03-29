package com.example.roomcodelab.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomcodelab.Entity.Word


@Dao
interface WordDao{

    @Query("SELECT * from word_table ORDER By word ASC")
    fun getAlphabetizedWords() : LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}