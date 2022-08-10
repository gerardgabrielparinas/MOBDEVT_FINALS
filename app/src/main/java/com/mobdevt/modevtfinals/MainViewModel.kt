package com.mobdevt.modevtfinals

import android.content.Intent
import android.util.Log
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobdevt.modevtfinals.util.MainHelper

class MainViewModel: ViewModel() {
    private val _question = MutableLiveData<String>()
    private val _answer = MutableLiveData<String>()
    private val _score = MutableLiveData<Int>()
    private val _name = MutableLiveData<String>()

    private var index = -1

    val question:LiveData<String> = _question
    val answer:LiveData<String> = _answer
    val score:LiveData<Int> = _score
    val name:LiveData<String> =_name

    fun loadQuestion(difficulty: Int, index: Int) {
        if (difficulty == 1) {
            _question.value = MainHelper.getEasyQuestion(index)
            _answer.value = MainHelper.getEasyAnswer(index)

        }
        else if (difficulty == 2) {
            _question.value = MainHelper.getMediumQuestion(index)
            _answer.value = MainHelper.getMediumAnswer(index)
            Log.i("hello", index.toString())

        }
        else if (difficulty == 3) {
            _question.value = MainHelper.getHardQuestion(index)
            _answer.value = MainHelper.getHardAnswer(index)

        }

    }

    fun checkAnswer(answer: String, level: Int) {
        if (answer == _answer.value) {
            _score.value = _score.value?.plus(1)
        }
        index++
        loadQuestion(level, index)
    }
}