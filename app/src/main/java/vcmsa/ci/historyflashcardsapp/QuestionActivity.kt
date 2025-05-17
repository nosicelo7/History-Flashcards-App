package vcmsa.ci.historyflashcardsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

data class Flashcard(val question: String, val answer: Boolean)

class QuestionActivity : AppCompatActivity() {
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

            showQuestion()

            findViewById<Button>(R.id.btnTrue).setOnClickListener { checkAnswer(true)
            findViewById<Button>(R.id.btnFalse).setOnClickListener { checkAnswer(false)
            findViewById<Button>(R.id.btnNext).setOnClickListener { showNextQuestion()
        }

        fun showQuestion() {
            findViewById<TextView>(R.id.txtQuestion).text =
            questionScreen[currentQuestionIndex].question
        }

        fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionScreen[currentQuestionIndex].answer
        val feedback = if (userAnswer == correctAnswer) {
            correctAnswers++
            "Correct!"
            } else {
            "Incorrect."
            }
            findViewById<TextView>(R.id.txtFeedback).text = feedback
        }

        @SuppressLint("SuspiciousIndentation")
        fun showNextQuestion() {
             currentQuestionIndex++
             if (currentQuestionIndex < questionScreen.size) {
                 showQuestion()
             findViewById<TextView>(R.id.txtFeedback).text = ""
                 } else {
        val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("correctAnswers", correctAnswers)
            startActivity(intent)
               finish()
                        }
                    }
                }
            }
        }
    private fun showQuestion() {
    }

    private fun showNextQuestion() {
    }

    private fun checkAnswer(b: Boolean) {
    }
}
