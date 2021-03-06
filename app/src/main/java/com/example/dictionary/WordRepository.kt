package com.example.dictionary

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.dictionary.database.AppDatabase
import com.example.dictionary.database.Word
import com.example.dictionary.database.WordDao

object WordRepository {
    lateinit var wordDao: WordDao
    var allWords: LiveData<List<Word?>?>?=null
    fun initDB(context: Context) {
        val db = AppDatabase.getAppDataBase(context)
        wordDao = db!!.wordDao()
        allWords = wordDao.getAllWords()
    }


    fun getAllWord():LiveData<List<Word?>?>?{
        return allWords
    }

    fun addWord(word:Word){
        wordDao.insertWord(word)
    }

    fun updateWord(word: Word){
        wordDao.updateWord(word)
    }

    fun deleteWord(wordID: Int){
        wordDao.deleteWord(wordID)
    }

    fun findEngWordByName(name: String):Word{
        return wordDao.findEnglishWord(name)
    }

    fun findPersianWordByName(name: String):Word{
        return wordDao.findPersianWord(name)
    }

    fun findWordByID(id:Int):Word{
        return wordDao.findByID(id)
    }

    fun getNumOfWords():Int?{
        return wordDao.getNumberOfWords()
    }




}