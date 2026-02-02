package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnCalc = findViewById<Button>(R.id.btnCalc)

        btnCalc.setOnClickListener {

            if (etWeight.text.isEmpty() || etHeight.text.isEmpty()) {
                tvResult.text = "Please enter all values"
                return@setOnClickListener
            }

            val weight = etWeight.text.toString().toFloat()
            val heightCm = etHeight.text.toString().toFloat()
            val heightM = heightCm / 100

            val bmi = weight / (heightM * heightM)

            val status = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25 -> "Normal"
                bmi < 30 -> "Overweight"
                else -> "Obese"
            }

            tvResult.text = "BMI: %.2f (%s)".format(bmi, status)
        }
    }
}
