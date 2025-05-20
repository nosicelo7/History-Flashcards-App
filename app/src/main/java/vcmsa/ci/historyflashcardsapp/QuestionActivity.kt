// Background Image reference
// Title: History Background
// Author: Pinterest
// Date: 15 May 2025
// Version: 1.0
// Available:https://za.pinterest.com/pin/80431543340224772/

package vcmsa.ci.historyflashcardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

data class Flashcard(val question: String, val answer: Boolean)

class QuestionActivity : AppCompatActivity() {
    // List of questions, each with its text and answer
    private val questionScreen = listOf(
        Flashcard("The earth is flat.", false),
        Flashcard("The capital of France is Paris.", true),
        Flashcard("The capital of France is Paris.", true),
        Flashcard("The Eiffel Tower is located in Paris.", true),
        Flashcard("The Great Wall of China is visible from space.", false)
    )

    private var currentQuestionIndex = 0
    private var correctAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)

        // Reference UI elements by their IDs
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)

        // Set click listeners for the buttons
        btnTrue.setOnClickListener { checkAnswer(true) }
        btnFalse.setOnClickListener { checkAnswer(false) }
        btnNext.setOnClickListener { showNextQuestion() }

        // Show the first question
        showQuestion()
    }

    // Show the current question
    private fun showQuestion() {
        // Set the question text and clear the previous feedback
        findViewById<TextView>(R.id.txtQuestion).text =
            questionScreen[currentQuestionIndex].question
        findViewById<TextView>(R.id.txtFeedback).text = ""
    }

    // Check the user's answer and show the feedback
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionScreen[currentQuestionIndex].answer
        val feedback = if (userAnswer == correctAnswer) {
            correctAnswers++
            "Correct!"
        } else {
            "Incorrect!"
        }
        // Display the feedback
        findViewById<TextView>(R.id.txtFeedback).text = feedback
    }

    // Move to the next question or finish the quiz
    private fun showNextQuestion() {
        currentQuestionIndex++
        if (currentQuestionIndex < questionScreen.size) {
            // Display the next question
            showQuestion()
        } else {
            // All questions answered, go to result screen
            val intent = Intent(this, ScoreScreen::class.java)
            intent.putExtra("correctAnswers", correctAnswers)
            startActivity(intent)
            finish()
        }
    }
}





