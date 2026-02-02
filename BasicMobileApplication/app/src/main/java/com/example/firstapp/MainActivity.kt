package com.example.firstapp

import android.graphics.Color
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val btnFontSize = findViewById<Button>(R.id.btnFontSize)
        val btnFontColor = findViewById<Button>(R.id.btnFontColor)
        val btnBgColor = findViewById<Button>(R.id.btnBgColor)
        val main = findViewById<LinearLayout>(R.id.main)

        // Change font size
        var fontSize: Float = 10f
        btnFontSize.setOnClickListener {
            textView.setTextSize(fontSize)
            fontSize = ((fontSize+10)%50)
        }

        // Change font color
        var fontColor: Int=5
        btnFontColor.setOnClickListener {
            when(fontColor%5){
                0 -> textView.setTextColor(Color.RED)
                1 -> textView.setTextColor(Color.YELLOW)
                2 -> textView.setTextColor(Color.BLUE)
                3 -> textView.setTextColor(Color.GREEN)
                4 -> textView.setTextColor(Color.MAGENTA)
            }
            fontColor++
        }

        // Change background color
        var bgColor: Int=5
        btnBgColor.setOnClickListener {
            when(bgColor%5){
                1 -> main.setBackgroundColor(Color.RED)
                2 -> main.setBackgroundColor(Color.YELLOW)
                3 -> main.setBackgroundColor(Color.BLUE)
                4 -> main.setBackgroundColor(Color.GREEN)
                0 -> main.setBackgroundColor(Color.MAGENTA)
            }
            bgColor++
            /*if (isBgYellow) {
                textView.setBackgroundColor(Color.LTGRAY)
            } else {
                textView.setBackgroundColor(Color.YELLOW)
            }
            isBgYellow = !isBgYellow*/
        }
    }
}
