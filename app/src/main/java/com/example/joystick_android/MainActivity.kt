package com.example.joystick_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.joystick_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ga1.setOnJoystickMoveListener(object: JoystickView.OnJoystickMoveListener {
            override fun onValueChanged(angle: Int, power: Int, direction: Int) {
                Log.e("fuck","$angle $power $direction")
                val tAngle = -angle+90
                val x = (power * Math.cos(Math.toRadians(tAngle.toDouble()))).toInt()
                val y = (power * Math.sin(Math.toRadians(tAngle.toDouble()))).toInt()
                Log.e("gaga","$x $y")
            }

        }, 50)
    }
}