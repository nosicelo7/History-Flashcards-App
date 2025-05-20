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

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

        val score = intent.getIntExtra("score", 0)
        val message = when {
            score == 5 -> "Congratulations! You got all the questions right!"
            score >= 3 -> "Good job! You got $score out of 5 questions right."
            else -> "Keep practicing! You got $score out of 5 questions right."

        }
        findViewById<TextView>(R.id.txtTotalScore).text = "Your Score: $score /5 "

        findViewById<TextView>(R.id.feedbackTextView).text = "$message"

        findViewById<TextView>(R.id.btnExit).setOnClickListener {
            finishAffinity()
        }
    }
}

