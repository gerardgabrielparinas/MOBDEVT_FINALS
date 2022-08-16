package com.mobdevt.modevtfinals

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobdevt.modevtfinals.util.MainHelper
import com.mobdevt.modevtfinals.util.MainHelper.Companion.quizLevel
import kotlin.properties.Delegates

class MainViewModel: ViewModel() {
    private val _question = MutableLiveData<String>()
    private val _answer = MutableLiveData<String>()
    private val _score = MutableLiveData<Int>()
    private val _scoreValue = MutableLiveData<Int>()
    private val _count = MutableLiveData<Int>()

    private var easyIndex: Int = 0
    private var mediumIndex: Int = 0
    private var hardIndex: Int = 0
    var tempIndex: Int = 0

    val question:LiveData<String> = _question
    val answer:LiveData<String> = _answer
    val score:LiveData<Int> = _score
    val scoreValue:LiveData<Int> = _scoreValue
    val count:LiveData<Int> = _count


    init {
        loadQuestion(quizLevel, 0)
        _score.value = 0
    }


    fun loadQuestion(difficulty: Int, questionIndex: Int) {
        when (difficulty) {
            1 -> {_question.value = MainHelper.getEasyQuestion(questionIndex)
                _answer.value = MainHelper.getEasyAnswer(questionIndex) }
            2 -> {_question.value = MainHelper.getMediumQuestion(questionIndex)
                _answer.value = MainHelper.getMediumAnswer(questionIndex)
            }
            3 -> {_question.value = MainHelper.getHardQuestion(questionIndex)
                _answer.value = MainHelper.getHardAnswer(questionIndex)
            }
        }

    }


    fun checkAnswer(answer: String, level: Int) {


        when(answer){
            _answer.value -> _score.value = _score.value!! + 1
            else -> _score.value = _score.value!! + 0
        }
        Log.i("DEBUG", "Current Score is: ${_score.value}")
        MainHelper.setScore(_score.value!!)

        when(level){
            1 -> {
                easyIndex++
                tempIndex = easyIndex
            }
            2 -> {
                mediumIndex++
                tempIndex = mediumIndex
            }
            3 -> {
                hardIndex++
                tempIndex = hardIndex
            }
        }

        /* when{
            _count.value!! > 10 -> _count.value!! + 1
            else -> _count.value!! + 0
        } */

        loadQuestion(level, tempIndex)

    }

    fun resetProgress() {
        easyIndex = -1
        mediumIndex = -1
        hardIndex = -1
        _score.value = 0
    }

    fun checkLast(lastAnswer: String) {
        when(lastAnswer){
            _answer.value -> _score.value = _score.value!! + 1
            else -> _score.value = _score.value!! + 0
        }
        Log.i("DEBUG", "Current Score is: ${_score.value}")
        MainHelper.setScore(_score.value!!)
    }
}