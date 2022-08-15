package com.mobdevt.modevtfinals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobdevt.modevtfinals.util.MainHelper
import kotlin.properties.Delegates

class MainViewModel: ViewModel() {
    private val _question = MutableLiveData<String>()
    private val _answer = MutableLiveData<String>()
    private val _score = MutableLiveData<Int>()


    private var easyIndex: Int = 0
    private var mediumIndex: Int = 0
    private var hardIndex: Int = 0

    val question:LiveData<String> = _question
    val answer:LiveData<String> = _answer
    val score:LiveData<Int> = _score


    fun loadQuestion(difficulty: Int, questionIndex: Int) {
        if (difficulty == 1) {
            _question.value = MainHelper.getEasyQuestion(questionIndex)
            _answer.value = MainHelper.getEasyAnswer(questionIndex)

        }
        else if (difficulty == 2) {
            _question.value = MainHelper.getMediumQuestion(questionIndex)
            _answer.value = MainHelper.getMediumAnswer(questionIndex)

        }
        else if (difficulty == 3) {
            _question.value = MainHelper.getHardQuestion(questionIndex)
            _answer.value = MainHelper.getHardAnswer(questionIndex)

        }

    }

    fun checkAnswer(answer: String, level: Int) {
        var tempIndex: Int = 0
        if (answer == _answer.value) {
            _score.value = _score.value?.plus(1)
        }

        if (level == 1) {
            easyIndex++
            tempIndex = easyIndex
        }
        else if (level == 2) {
            mediumIndex++
            tempIndex = mediumIndex
        }
        else if (level == 3) {
            hardIndex++
            tempIndex = hardIndex
        }
        loadQuestion(level, tempIndex)
    }

    fun resetProgress() {
        easyIndex = -1
        mediumIndex = -1
        hardIndex = -1
        _score.value = 0
    }

    fun checkLast(lastAnswer: String) {
        if (lastAnswer == _answer.value) {
            _score.value = _score.value?.plus(1)
        }
    }
}