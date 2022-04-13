package org.tensorflow.lite.examples.posenet

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import org.tensorflow.lite.examples.posenet.mainFeatures.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoButton: Button = findViewById(R.id.info_button)
        // Set a click listener for button widget
        infoButton.setOnClickListener{
            // Initialize a new layout inflater instance
            val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            // Inflate a custom view using layout inflater
            val view = inflater.inflate(R.layout.another_view,null)

            // Initialize a new instance of popup window
            val popupWindow = PopupWindow(
                view, // Custom view to show in popup window
                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                LinearLayout.LayoutParams.WRAP_CONTENT // Window height
            )

            // Set an elevation for the popup window
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                popupWindow.elevation = 10.0F
            }


            // If API level 23 or higher then execute the code
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                // Create a new slide animation for popup window enter transition
                val slideIn = Slide()
                slideIn.slideEdge = Gravity.TOP
                popupWindow.enterTransition = slideIn

                // Slide animation for popup window exit transition
                val slideOut = Slide()
                slideOut.slideEdge = Gravity.RIGHT
                popupWindow.exitTransition = slideOut

            }

            // Get the widgets reference from custom view
            val buttonPopup = view.findViewById<Button>(R.id.button_popup)


            // Set a click listener for popup's button widget
            buttonPopup.setOnClickListener{
                // Dismiss the popup window
                popupWindow.dismiss()
            }

            // Set a dismiss listener for popup window
            popupWindow.setOnDismissListener {
                Toast.makeText(applicationContext,"Popup closed", Toast.LENGTH_SHORT).show()
            }


            // Finally, show the popup window on app
            TransitionManager.beginDelayedTransition(root_layout)
            popupWindow.showAtLocation(
                root_layout, // Location to display popup window
                Gravity.CENTER, // Exact position of layout to display popup
                0, // X offset
                0 // Y offset
            )
        }

        leader_button.setOnClickListener {
            val intent = Intent(this,Leaderboard::class.java)
            startActivity(intent)
        }

        user_button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Androidly Alert")
            builder.setMessage("Do you want to logout")
            //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(applicationContext,
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(applicationContext,
                    android.R.string.no, Toast.LENGTH_SHORT).show()
            }

            builder.setNeutralButton("Maybe") { dialog, which ->
                Toast.makeText(applicationContext,
                    "Maybe", Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }

        water_button.setOnClickListener {
            val intent = Intent(this, WaterIcon::class.java)
            startActivity(intent)
        }

        stop_button.setOnClickListener {
            val intent = Intent(this, TakeBreak::class.java)
            startActivity(intent)
        }

        jogging_button.setOnClickListener {
            val intent = Intent(this, Jogging::class.java)
            startActivity(intent)
        }

        fruits_button.setOnClickListener {
            val intent = Intent(this, Fruits::class.java)
            startActivity(intent)
        }

        exercise_button.setOnClickListener {
            val intent = Intent(this,CameraActivity::class.java)
            startActivity(intent)
        }
        yoga_button.setOnClickListener {
            val intent = Intent(this, Yoga::class.java)
            startActivity(intent)
        }

    }
}