package org.tensorflow.lite.examples.posenet.mainFeatures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_water_icon.*
import org.tensorflow.lite.examples.posenet.R

class WaterIcon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_icon)

        var totalWater : Int= total_water.text.toString().toInt()
        var sum: Int = 0

        water_button_250.setOnClickListener {
            sum += totalWater+250
            total_water.text = sum.toString()
        }
        water_button_500.setOnClickListener {
            sum += totalWater+500
            total_water.text = sum.toString()
        }
        water_button_1000.setOnClickListener {
            sum +=totalWater+1000
            total_water.text = sum.toString()
        }
        if(sum>=3000){
            water_target_complete.text = "Today's target completed"
            Toast.makeText(applicationContext,
                "You have completed today's target", Toast.LENGTH_SHORT).show()
        }

    }

}