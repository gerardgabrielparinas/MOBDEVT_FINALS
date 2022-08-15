package com.mobdevt.modevtfinals.util

class MainHelper {
    companion object {
        private val easyQuestions = listOf(Question("What is the time complexity to insert an element to the rear of a LinkedList(head pointer given)?", "O(n)")
            , Question("What data structure is mainly used for implementing the recursive algorithm?", "Stack")
            , Question("What is the time complexity to insert an element to the front of a LinkedList(head pointer given)?", "O(1)")
            , Question("If two trees have same structure and node content, then they are\n" +
                    "called ____\n", "Equivalent trees")
            , Question("If two trees have same structure and but different node content,\n" +
                    "then they are called ___", "Similar trees")
            , Question("Finding the location of a given item in a collection of items is called ……", "Searching")
            , Question("The time complexity of quicksort is", "O(n logn)")
            , Question(" ………. sorting is good to use when alphabetizing a large list of names.", "Radix")
            , Question(". The total number of comparisons in a bubble sort is ….", "O(n logn)")
            , Question(". ……… form of access is used to add and remove nodes from a queue (FIFO or LIFO)", "FIFO"))

        private val mediumQuestions = listOf(Question("When a pop() operation is called on an empty queue, what is the condition called?", "Underflow"),
            Question("What data structures finds its use in recursion?", "Stack"),
            Question("What data structures allow insertion and deletion from both ends?", "Deque")
            ,Question("What is sorting algorithms provide the best time complexity in the worst-case scenario?", "Merge Sort")
            ,Question("What is the maximum number of swaps that can be performed in the Selection Sort algorithm?(no space)", "n-1")
            ,Question("What data structure is a Divide and Conquer algorithm?", "Merge Sort")
            ,Question("What will be the best sorting algorithm, given that the array elements are small (<= 1e6)", "Counting Sort")
            ,Question("What is the time complexity of the binary search algorithm?", "O(log2n)")
            ,Question("Maps in C++ are implemented using which of the following data structures?", "Red-Black Trees")
            ,Question("What is the best time complexity we can achieve to precompute all-pairs shortest paths in a weighted graph??", "O(n^3)"))

        private val hardQuestions = listOf(Question("What is the worst-case and average-case time complexity of the Binary search?", "O(log n)"),
            Question("The minimum number of comparisons for a particular record 32 sorted records through binary search method will be?", "5"),
            Question("The input hexadecimal representation of 1110 is?", "E"),
            Question("The octal equivalent of 1100101.001010 is?", "145.12"),
            Question("The value of radix in binary number system is?", "2"),
            Question("Kruskal’s Algorithm for finding the Minimum Spanning Tree of a graph is a kind of a?", "Greedy Algorithm"),
            Question("In what time complexity can we find the diameter of a binary tree optimally?", "O(V+E)"),
            Question("In a graph of n nodes and n edges, how many cycles will be present?", "1"),
            Question("A node in a tree, such that removing it splits the tree into forests, with size of each connected component being not greater than n / 2 is called?", "Centroid"),
            Question("Whatalgorithm are used to find the shortest path from a source node to all other nodes in a weighted graph?", "Djikstra's Algorithm"),
        )
        //don't mind this!
        /*https://testbook.com/objective-questions/mcq-on-binary--5eea6a0c39140f30f369e0c8?adlt=strict&toWww=1&redig=41FCE4AFC5924CAB91B07BF61E64760F*/
        /*https://engineeringinterviewquestions.com/mcqs-on-the-binary-number-system-answers/?adlt=strict&toWww=1&redig=7DEB872DF6D6439F8C4FD57EA831E9B7*/

        var quizLevel: Int = 0
        var easyMaxIndex : Int = easyQuestions.size - 1
        var mediumMaxIndex: Int = mediumQuestions.size - 1
        var hardMaxIndex: Int = hardQuestions.size - 1
        private var isLast: Boolean = false

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
    }
}

data class Question(val question:String, val answer:String)