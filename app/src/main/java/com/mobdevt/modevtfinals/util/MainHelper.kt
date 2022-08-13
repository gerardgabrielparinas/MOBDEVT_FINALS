package com.mobdevt.modevtfinals.util

class MainHelper {
    companion object {
        private val easyQuestions = listOf(Question("Easy Question 1", "Easy Answer 2"), Question("Easy Question 2", "Easy Answer 2"))
        private val mediumQuestions = listOf(Question("My name is?", "Reuel"), Question("Medium Question 1", "Medium Answer 1"))






        private val hardQuestions = listOf(Question("What is the worst-case and average-case time complexity of the Binary search?", "O(log n)"),
                                           Question("The minimum number of comparisons for a particular record 32 sorted records through binary search method will be?", "5"),
                                           Question("The input hexadecimal representation of 1110 is?", "E"),
                                           Question("The octal equivalent of 1100101.001010 is?", "145.12"),
                                           Question("The value of radix in binary number system is?", "2"),
        )
        //don't mind this!
        /*https://testbook.com/objective-questions/mcq-on-binary--5eea6a0c39140f30f369e0c8?adlt=strict&toWww=1&redig=41FCE4AFC5924CAB91B07BF61E64760F*/
        /*https://engineeringinterviewquestions.com/mcqs-on-the-binary-number-system-answers/?adlt=strict&toWww=1&redig=7DEB872DF6D6439F8C4FD57EA831E9B7*/

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