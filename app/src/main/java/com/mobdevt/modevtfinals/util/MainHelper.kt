package com.mobdevt.modevtfinals.util

class MainHelper {
    companion object {
        private val easyQuestions = listOf(Question("1. What is the time complexity to insert an element to the rear of a LinkedList(head pointer given)?", "O(n)")
                                         , Question("2. What data structure is mainly used for implementing the recursive algorithm?", "Stack")
                                         , Question("3. What is the time complexity to insert an element to the front of a LinkedList(head pointer given)?", "O(1)")
                                         , Question("4. If two trees have same structure and node content, then they are\n" +
                    "called ____\n", "Equivalent trees")
                                         , Question("5. If two trees have same structure and but different node content,\n" +
                    "then they are called ___", "Similar trees")
                                         , Question("6. Finding the location of a given item in a collection of items is called ……", "Searching")
                                         , Question("7. The time complexity of quicksort is", "O(n logn)")
                                         , Question("8. ………. sorting is good to use when alphabetizing a large list of names.", "Radix")
                                         , Question("9. The total number of comparisons in a bubble sort is ….", "O(n logn)")
                                         , Question("10. ……… form of access is used to add and remove nodes from a queue (FIFO or LIFO)", "FIFO"))

        private val mediumQuestions = listOf(Question("1. When a pop() operation is called on an empty queue, what is the condition called?", "Underflow"),
                                             Question("2. What data structures finds its use in recursion?", "Stack"),
                                             Question("3. What data structures allow insertion and deletion from both ends?", "Deque")
                                            ,Question("4. What is sorting algorithms provide the best time complexity in the worst-case scenario?", "Merge Sort")
                                            ,Question("5. What is the maximum number of swaps that can be performed in the Selection Sort algorithm?(no space)", "n-1")
                                            ,Question("6. What data structure is a Divide and Conquer algorithm?", "Merge Sort")
                                            ,Question("7. What will be the best sorting algorithm, given that the array elements are small (<= 1e6)", "Counting Sort")
                                            ,Question("8. What is the time complexity of the binary search algorithm?", "O(log2n)")
                                            ,Question("9. Maps in C++ are implemented using which of the following data structures?", "Red-Black Trees")
                                            ,Question("10. What is the best time complexity we can achieve to precompute all-pairs shortest paths in a weighted graph??", "O(n^3)"))

        private val hardQuestions = listOf(Question("1. What is the worst-case and average-case time complexity of the Binary search?", "O(log n)"),
                                           Question("2. The minimum number of comparisons for a particular record 32 sorted records through binary search method will be?", "5"),
                                           Question("3. The input hexadecimal representation of 1110 is?", "E"),
                                           Question("4. The octal equivalent of 1100101.001010 is?", "145.12"),
                                           Question("5. The value of radix in binary number system is?", "2"),
                                           Question("6. Kruskal’s Algorithm for finding the Minimum Spanning Tree of a graph is a kind of a?", "Greedy Algorithm"),
                                           Question("7. In what time complexity can we find the diameter of a binary tree optimally?", "O(V+E)"),
                                           Question("8. In a graph of n nodes and n edges, how many cycles will be present?", "1"),
                                           Question("9. A node in a tree, such that removing it splits the tree into forests, with size of each connected component being not greater than n / 2 is called?", "Centroid"),
                                           Question("10. What algorithm are used to find the shortest path from a source node to all other nodes in a weighted graph?", "Djikstra's Algorithm"),
        )
        //References:
        /*https://testbook.com/objective-questions/mcq-on-binary--5eea6a0c39140f30f369e0c8?adlt=strict&toWww=1&redig=41FCE4AFC5924CAB91B07BF61E64760F*/
        /*https://engineeringinterviewquestions.com/mcqs-on-the-binary-number-system-answers/?adlt=strict&toWww=1&redig=7DEB872DF6D6439F8C4FD57EA831E9B7*/

        var quizLevel: Int = 0
        private var isLast: Boolean = false
        private var score: Int = 0
        private var maxIndex = 0
        private var count = 0

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
        fun setLast(last: Boolean) {
            isLast = last
        }
        fun getLast(): Boolean {
            return isLast
        }

        fun setScore(score: Int) {
            this.score = score
        }
        fun getScore(): Int {
            return score
        }

        fun getMaxIndex(level: Int): Int {
            when(level){
                1 -> {
                    maxIndex = easyQuestions.indexOf(easyQuestions.last())
                }
                2 -> {
                    maxIndex = mediumQuestions.indexOf(mediumQuestions.last())
                }
                3 -> {
                    maxIndex = hardQuestions.indexOf(hardQuestions.last())
                }
            }
            return maxIndex
        }

        fun incrementCount() {
            count++
        }
        fun sameCount() {
            count + 0
        }

        fun resetCount() {
            count = 0
        }
        fun getCount(): Int {
            return count
        }
    }
}

data class Question(val question:String, val answer:String)