package com.example.class_quizapp

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    private val quizList = LocalDataSource.quizList
    var currentIndex = 0
        private set
    var score = 0
        private set


    fun getCurrentQuestion(): String = quizList[currentIndex].question


    fun getOptions(): List<String> = quizList[currentIndex].options


    fun getCorrectAnswerIndex(): Int = quizList[currentIndex].correctIndex


    fun checkAnswer(selectedIndex: Int): Boolean {
        val isCorrect = selectedIndex == quizList[currentIndex].correctIndex
        if (isCorrect) score++
        return isCorrect
    }


    fun hasNextQuestion(): Boolean = currentIndex < quizList.size - 1

    fun moveToNextQuestion() {
        if (hasNextQuestion()) currentIndex++
    }

    fun totalQuestions(): Int = quizList.size

    fun resetQuiz() {
        currentIndex = 0
        score = 0
    }
}
