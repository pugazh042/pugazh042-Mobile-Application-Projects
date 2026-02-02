package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTemp = findViewById<EditText>(R.id.etTemp)
        val rbCtoF = findViewById<RadioButton>(R.id.rbCtoF)
        val rbFtoC = findViewById<RadioButton>(R.id.rbFtoC)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnConvert.setOnClickListener {
            val tempText = etTemp.text.toString()

            if (tempText.isEmpty()) {
                // Just print in the result TextView
                tvResult.text = "Please enter a temperature"
            } else {
                val temp = tempText.toDouble()

                if (rbCtoF.isChecked) {
                    val result = (temp * 9 / 5) + 32
                    tvResult.text = "Result: $result °F"
                } else if (rbFtoC.isChecked) {
                    val result = (temp - 32) * 5 / 9
                    tvResult.text = "Result: $result °C"
                }
            }
        }
    }
}
