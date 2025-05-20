// Background Image reference
// Title: Phone Wallpaper
// Author: Canva
// Date: 14 May 2025
// Version: 1.0
// Available:https://www.canva.com/design/DAGleWV569A/2BBgmxE6BUMsDD1ZWw74OA/edit?utm_content=DAGleWV569A&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton

package vcmsa.ci.historyflashcardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // The onCreate is the entry point for the activity.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Layout for activity is set. The layout is defined in res/layout/activity_main.xml
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Retrieve the UI elements from the layout by their IDs
        // TextView used to display the Welcome text for user.
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        // TextView used to display the description of the app.
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
        // Button used to start the quiz.
        val startButton = findViewById<Button>(R.id.startButton)
        // Title: Create Custom UI Components with Kotlin Extensions in Android
        // Author: Codezup
        // Date: 27 April 2025
        // Version: 1.0
        // Available:https://codezup.com/android-kotlin-ui-components/#:~:text=In%20Kotlin%2C%20UI%20components%20are%20built%20using%20the,extend%20the%20functionality%20of%20Jetpack%20Compose%20UI%20components.

        // OnClickListener is set for Start the Quiz Button
        startButton.setOnClickListener {
            // Retrieve the questions input field as a String
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }

    }
}