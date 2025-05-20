// Background Image reference
// Title: History Background
// Author: Pinterest
// Date: 15 May 2025
// Version: 1.0
// Available:https://za.pinterest.com/pin/303359724920294592/

package vcmsa.ci.historyflashcardsapp

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
        val score = intent.getIntExtra("score", 0)
        // Determine feedback message based on the score
        val message = when {
            score == 5 -> "Congratulations! You got all the questions right!"
            score >= 3 -> "Good job! You got $score out of 5 questions right."
            else -> "Keep practicing! You got $score out of 5 questions right."

        }

        // Display the total score in the txtTotalScore TextView
        findViewById<TextView>(R.id.txtTotalScore).text = "Your Score: $score /5 "

        // Display the feedback message in the feedbackTextView
        findViewById<TextView>(R.id.feedbackTextView).text = "$message"

        // Set up the Exit button to close the app when clicked
        findViewById<Button>(R.id.btnExit).setOnClickListener {
            finishAffinity()         // Closes all activities and exits the app
        }
    }
}

