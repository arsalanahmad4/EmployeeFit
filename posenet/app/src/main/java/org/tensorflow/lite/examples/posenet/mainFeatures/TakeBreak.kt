package org.tensorflow.lite.examples.posenet.mainFeatures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_take_break.*
import org.tensorflow.lite.examples.posenet.R

class TakeBreak : AppCompatActivity() {

    var START_MILLI_SECONDS = 60000L

    lateinit var countdown_timer: CountDownTimer
    var isRunning: Boolean = false;
    var time_in_milli_seconds = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_break)


        button.setOnClickListener {
            if (isRunning) {
                pauseTimer()
            } else {
                val time  = "5"
                time_in_milli_seconds = time.toLong() *60000L
                startTimer(time_in_milli_seconds)
            }
        }

        reset.setOnClickListener {
            resetTimer()
        }


    }

    private fun pauseTimer() {

        button.text = "Start"
        countdown_timer.cancel()
        isRunning = false
        reset.visibility = View.VISIBLE
    }

    private fun startTimer(time_in_seconds: Long) {
        countdown_timer = object : CountDownTimer(time_in_seconds, 1000) {
            override fun onFinish() {

            }

            override fun onTick(p0: Long) {
                time_in_milli_seconds = p0
                updateTextUI()
            }
        }
        countdown_timer.start()
        isRunning = true
        button.text = "Pause"
        reset.visibility = View.INVISIBLE

    }

    private fun resetTimer() {
        time_in_milli_seconds = START_MILLI_SECONDS
        updateTextUI()
        reset.visibility = View.INVISIBLE
    }

    private fun updateTextUI() {
        val minute = (time_in_milli_seconds / 1000) / 60
        val seconds = (time_in_milli_seconds / 1000) % 60

        timer.text = "$minute:$seconds"
    }


}