package com.example.class_quizapp

data class Quiz(
    val question: String,
    val options: List<String>,
    val correctIndex: Int
)
