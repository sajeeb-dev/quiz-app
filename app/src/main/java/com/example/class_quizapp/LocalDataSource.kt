package com.example.class_quizapp

object LocalDataSource {

    val quizList = listOf(
        Quiz(
            "Which of the following is a programming language?",
            listOf("HTML", "Python", "Google", "WhatsApp"),
            1
        ),
        Quiz(
            "Which planet is known as the Red Planet?",
            listOf("Earth", "Mars", "Jupiter", "Venus"),
            1
        ),
        Quiz(
            "What is the capital of Bangladesh?",
            listOf("Dhaka", "Chittagong", "Rajshahi", "Khulna"),
            0
        ),
        Quiz(
            "Which company developed Android?",
            listOf("Google", "Apple", "Microsoft", "Nokia"),
            0
        ),
        Quiz(
            "Which of these is not an operating system?",
            listOf("Windows", "Linux", "Python", "macOS"),
            2
        ),
        Quiz(
            "Which device is used to process data?",
            listOf("Monitor", "Printer", "Keyboard", "CPU"),
            3
        ),
        Quiz(
            "Which keyword is used to define a class in Kotlin?",
            listOf("define", "class", "fun", "object"),
            1
        ),
        Quiz(
            "Which data type is used to store true or false in Kotlin?",
            listOf("Int", "Boolean", "String", "Float"),
            1
        ),
        Quiz(
            "Which company created the Java language?",
            listOf("Sun Microsystems", "Oracle", "Google", "IBM"),
            0
        ),
        Quiz(
            "Which tag is used to display an image in HTML?",
            listOf("<img>", "<image>", "<src>", "<pic>"),
            0
        )
    )
}
