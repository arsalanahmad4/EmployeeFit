package org.tensorflow.lite.examples.posenet.mainFeatures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_yoga.*
import org.tensorflow.lite.examples.posenet.R

class Yoga : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga)

        yoga_1.setOnClickListener {
            Header1.text = "SUKHASANA"
            Body1.text = " Come into a seated position with the buttocks on the floor, then cross the legs, placing the feet directly below the knees. Rest the hands on the knees or the lap with the palms facing up or down."
        }
        yoga_2.setOnClickListener {
            Header1.setTextSize(30F)
            Header1.text = "PASCHIMOTTANASANA"
            Body1.text = "From Staff pose, inhale the arms up over the head and lift and lengthen up through the fingers and crown of the head.Exhale and hinging at the hips, slowly lower the torso towards the legs.  Reach the hands to the toes, feet or ankles."
        }
        yoga_3.setOnClickListener {
            Body1.setTextSize(23F)
            Header1.text = "BHADRASANA"
            Body1.text ="Bring the knees to the floor with the knees hip width apart and the big toes touching. Carefully sit on your heels with heels touching the outside of hips. Spread the knees as wide as comfortable. Rest the hands on the knees with the palms facing down."
        }
    }
}