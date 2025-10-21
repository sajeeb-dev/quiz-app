package com.example.class_quizapp

class QuizManager {

    class QuizManager {

        val question = arrayOf(
            "Which of the following is a programming language?",
            "Which planet is known as the Red Planet?",
            "What is the capital of Bangladesh?"
        )

        val options = arrayOf(
            arrayOf("HTML", "Python", "Google", "WhatsApp"),
            arrayOf("Earth", "Mars", "Jupiter", "Venus"),
            arrayOf("Dhaka", "Chittagong", "Rajshahi", "Khulna")
        )

        val answer = arrayOf(1, 1, 0)
        var currentQuestionIndex = 0
        var score = 0

        fun isCorrect(selected: Int): Boolean {
            val correct = answer[currentQuestionIndex]
            if (selected == correct) {
                score++
                return true
            }
            return false
        }

        fun nextQuestion(): Boolean {
            if (currentQuestionIndex < question.size - 1) {
                currentQuestionIndex++
                return true
            }
            return false
        }
    }

}