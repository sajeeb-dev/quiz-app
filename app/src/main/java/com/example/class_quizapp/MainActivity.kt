package com.example.class_quizapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.class_quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: QuizViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        displayQuestion()


        binding.btnOption1.setOnClickListener { checkAnswer(0) }
        binding.btnOption2.setOnClickListener { checkAnswer(1) }
        binding.btnOption3.setOnClickListener { checkAnswer(2) }
        binding.btnOption4.setOnClickListener { checkAnswer(3) }

        binding.resetbtn.setOnClickListener { restartQuiz() }
    }

    private fun displayQuestion() {
        val question = viewModel.getCurrentQuestion()
        val options = viewModel.getOptions()

        binding.questionText.text = question
        binding.btnOption1.text = options[0]
        binding.btnOption2.text = options[1]
        binding.btnOption3.text = options[2]
        binding.btnOption4.text = options[3]
        resetButtonColors()
        enableButtons()
    }

    private fun checkAnswer(selectedIndex: Int) {
        disableButtons()

        val isCorrect = viewModel.checkAnswer(selectedIndex)
        val correctIndex = viewModel.getCorrectAnswerIndex()

        if (isCorrect) {
            highlightButton(selectedIndex, Color.GREEN)
        } else {
            highlightButton(selectedIndex, Color.RED)
            highlightButton(correctIndex, Color.GREEN)
        }

        // Next question or finish
        if (viewModel.hasNextQuestion()) {
            binding.questionText.postDelayed({
                viewModel.moveToNextQuestion()
                displayQuestion()
            }, 1000)
        } else {
            showResult()
        }
    }

    private fun showResult() {
        val total = viewModel.totalQuestions()
        val score = viewModel.score
        binding.tvScore.text = "You scored: $score out of $total"
        Toast.makeText(this, "Your Score: $score / $total", Toast.LENGTH_LONG).show()
        disableButtons()
        binding.resetbtn.isEnabled = true
    }

    private fun restartQuiz() {
        viewModel.resetQuiz()
        displayQuestion()
        binding.tvScore.text = "Score: 0"
        binding.resetbtn.isEnabled = false
    }

    private fun highlightButton(index: Int, color: Int) {
        when (index) {
            0 -> binding.btnOption1.setBackgroundColor(color)
            1 -> binding.btnOption2.setBackgroundColor(color)
            2 -> binding.btnOption3.setBackgroundColor(color)
            3 -> binding.btnOption4.setBackgroundColor(color)
        }
    }

    private fun resetButtonColors() {
        val defaultColor = Color.rgb(50, 59, 96)
        binding.btnOption1.setBackgroundColor(defaultColor)
        binding.btnOption2.setBackgroundColor(defaultColor)
        binding.btnOption3.setBackgroundColor(defaultColor)
        binding.btnOption4.setBackgroundColor(defaultColor)
    }

    private fun disableButtons() {
        binding.btnOption1.isEnabled = false
        binding.btnOption2.isEnabled = false
        binding.btnOption3.isEnabled = false
        binding.btnOption4.isEnabled = false
    }

    private fun enableButtons() {
        binding.btnOption1.isEnabled = true
        binding.btnOption2.isEnabled = true
        binding.btnOption3.isEnabled = true
        binding.btnOption4.isEnabled = true
    }
}
