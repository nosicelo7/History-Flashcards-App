// Background Image reference
// Title: History Background
// Author: Pinterest
// Date: 15 May 2025
// Version: 1.0
// Available:https://za.pinterest.com/pin/303359724920294592/

//Title:IMAD5112 Module Manual
//Author: The IIE
//Date: 16 May 2025
//Available:https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true

package vcmsa.ci.historyflashcardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// This activity displays the user's score and feedback after completing the quiz
class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout for the score screen activity
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        // Retrieve the score passed from the previous activity (default to 0 if not found)
        val correctAnswers = intent.getIntExtra("correctAnswers",0)
        // Determine feedback message based on the score
        val message = if (correctAnswers == 5) {
            "Congratulations! You got all the questions right!"
        } else if (correctAnswers >= 3) {
            "Good job! You got $correctAnswers out of 5 questions right."
        } else {
            "Keep practicing! You got $correctAnswers out of 5 questions right."
        }

        val txtTotalScore = findViewById<TextView>(R.id.txtTotalScore)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val btnReview = findViewById<Button>(R.id.btnReview)

        txtTotalScore.text = ""
        feedbackTextView.text = ""

        // Display the total score in the txtTotalScore TextView
        btnReview.setOnClickListener {
            txtTotalScore.text = "Your Score: $correctAnswers /5 "

            // Display the feedback message in the feedbackTextView
            feedbackTextView.text = "$message"
        }
        // Set up the Exit button to close the app when clicked
        findViewById<Button>(R.id.btnExit).setOnClickListener {
            finishAffinity()         // Closes all activities and exits the app
        }
    }
}