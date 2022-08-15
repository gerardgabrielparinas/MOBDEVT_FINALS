package com.mobdevt.modevtfinals

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobdevt.modevtfinals.util.MainHelper

class MainViewModel: ViewModel() {
    private val _question = MutableLiveData<String>()
    private lateinit var _answer: String
    private val _score = MutableLiveData<Int>()


    private var _easyIndex: Int = 0
    private var _mediumIndex: Int = 0
    private var _hardIndex: Int = 0

    val question:LiveData<String> = _question
    val score:LiveData<Int> = _score

    var quizLevel: Int = MainHelper.quizLevel
    var tempIndex: Int = 0

    init {
        loadQuestion(quizLevel, 0)
        _score.value = 0
    }

    fun loadQuestion(difficulty: Int, questionIndex: Int) {
        MainHelper.setLast(false)
        if (difficulty == 1) {
            _question.value = MainHelper.getEasyQuestion(questionIndex)
            _answer = MainHelper.getEasyAnswer(questionIndex)

        }
        else if (difficulty == 2) {
            _question.value = MainHelper.getMediumQuestion(questionIndex)
            _answer = MainHelper.getMediumAnswer(questionIndex)

        }
        else if (difficulty == 3) {
            _question.value = MainHelper.getHardQuestion(questionIndex)
            _answer = MainHelper.getHardAnswer(questionIndex)

        }
    }

    fun checkAnswer(correctAnswer: String, level: Int) {
        try {
            if (correctAnswer.contains(_answer)) {
                Log.i("DEBUG", "IT WORKS!")
                _score.value = _score.value?.plus(1)

                Log.i("DEBUG", "Current Score is ${_score.value}")
            }

            if (level == 1) {
                _easyIndex++
                tempIndex = _easyIndex
            } else if (level == 2) {
                _mediumIndex++
                tempIndex = _mediumIndex
            } else if (level == 3) {
                _hardIndex++
                tempIndex = _hardIndex
            }
            loadQuestion(level, tempIndex)
        }
        catch (e: ArrayIndexOutOfBoundsException){
            Log.i("TEST", _score.value.toString())
            MainHelper.setLast(true)
        }
    }

    fun resetProgress() {
        _easyIndex = 0
        _mediumIndex = 0
        _hardIndex = 0
        _score.value = 0
    }

    fun loadScore() {
        _score.value = _score.value
    }
}