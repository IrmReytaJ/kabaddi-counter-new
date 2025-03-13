package com.example.kabaddikounternw

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var scoreA = 0
    private var scoreB = 0

    private lateinit var tvScoreA: TextView
    private lateinit var tvScoreB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvScoreA = findViewById(R.id.textView2)
        tvScoreB = findViewById(R.id.textView3)
        val buttonPlusOneA = findViewById<Button>(R.id.button)
        val buttonPlusTwoA = findViewById<Button>(R.id.button2)
        val buttonPlusOneB = findViewById<Button>(R.id.button3)
        val buttonPlusTwoB = findViewById<Button>(R.id.button4)
        val buttonReset = findViewById<Button>(R.id.buttonReset)

        // Menambah skor saat tombol ditekan
        buttonPlusOneA.setOnClickListener { addScoreA(1) }
        buttonPlusTwoA.setOnClickListener { addScoreA(2) }
        buttonPlusOneB.setOnClickListener { addScoreB(1) }
        buttonPlusTwoB.setOnClickListener { addScoreB(2) }
        buttonReset.setOnClickListener { resetScores() }
    }

    private fun addScoreA(points: Int) {
        scoreA += points
        tvScoreA.text = scoreA.toString()
    }

    private fun addScoreB(points: Int) {
        scoreB += points
        tvScoreB.text = scoreB.toString()
    }

    private fun resetScores() {
        scoreA = 0
        scoreB = 0
        tvScoreA.text = scoreA.toString()
        tvScoreB.text = scoreB.toString()
    }
}
