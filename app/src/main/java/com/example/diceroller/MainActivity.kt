package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val countUpButton: Button = findViewById(R.id.count_up_button)
        val resetButton: Button = findViewById(R.id.reset_button)

        val resultText: TextView = findViewById(R.id.result_text)

        rollButton.setOnClickListener() { rollDice() }
        countUpButton.setOnClickListener() { countUp() }
        resetButton.setOnClickListener() { reset() }
        resultText.text = getString(R.string.dice_rolled_message)
    }

    private fun rollDice() {
        val randomInt = (1..6).random()

        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        val rollNumber: Int? = resultText.text.toString().toIntOrNull()
        if (rollNumber != null) {
            if (rollNumber != 6) {
                resultText.text = (rollNumber + 1).toString()
            }
        } else {
            resultText.text = "1"
        }
    }
    
    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "0"
    }
}