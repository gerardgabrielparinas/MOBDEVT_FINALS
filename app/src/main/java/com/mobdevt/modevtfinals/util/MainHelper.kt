package com.mobdevt.modevtfinals.util

class MainHelper {
    companion object {
        private val easyQuestions = listOf(Question("Easy Question 1", "Easy Answer 2"), Question("Easy Question 2", "Easy Answer 2"))
        private val mediumQuestions = listOf(Question("Medium Question 0", "Medium Answer 0"), Question("Medium Question 1", "Medium Answer 1"))
        private val hardQuestions = listOf(Question("Hard Question 1", "Hard Answer 1"), Question("Hard Question 2", "Hard Answer 2"))

        fun getEasyQuestion(index:Int): String {
            return easyQuestions[index].component1()
        }
        fun getEasyAnswer(index: Int): String {
            return easyQuestions[index].component2()
        }

        fun getMediumQuestion(index: Int): String {
            return mediumQuestions[index].component1()
        }
        fun getMediumAnswer(index: Int): String {
            return mediumQuestions[index].component2()
        }

        fun getHardQuestion(index: Int): String {
            return hardQuestions[index].component1()
        }
        fun getHardAnswer(index: Int): String {
            return hardQuestions[index].component2()
        }
    }
}

data class Question(val question:String, val answer:String)