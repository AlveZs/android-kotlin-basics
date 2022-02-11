package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val numSides: Int = 6
    private val luckyNumber: Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val countUpButton: Button = findViewById(R.id.count_up_button)
        val resetButton: Button = findViewById(R.id.reset_button)

        rollButton.setOnClickListener() { rollDice() }
        countUpButton.setOnClickListener() { countUp() }
        resetButton.setOnClickListener() { reset() }
    }

    private fun rollDice() {
        val dice = Dice(numSides)
        val diceImage: ImageView = findViewById(R.id.dice_image)
        
        val rollResult = dice.roll()
        val drawableResource: Int = getDiceDrawableResource(rollResult)

        getMessageByResult(rollResult)
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = rollResult.toString()
    }

    private fun countUp() {
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val rollNumber: Int? = diceImage.contentDescription.toString().toIntOrNull()
        var resultNumber = 1

        if (rollNumber != null) {
            if (rollNumber != numSides) {
                resultNumber = rollNumber + 1
            }
        }

        setDiceImageView(resultNumber)
        getMessageByResult(resultNumber)
    }
    
    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)

        resultText.text = getString(R.string.placeholder_label)
        setDiceImageView(1)
    }

    private fun getDiceDrawableResource(rollNumber: Int): Int {
        return when(rollNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }
    }

    private fun setDiceImageView(rollNumber: Int) {
        val diceImage: ImageView = findViewById(R.id.dice_image)

        diceImage.setImageResource(getDiceDrawableResource(rollNumber))
        diceImage.contentDescription = rollNumber.toString()
    }

    private fun getMessageByResult(rollNumber: Int) {
        val resultText: TextView = findViewById(R.id.result_text)

        when (rollNumber) {
            luckyNumber -> resultText.text = "You won!"
            1 -> resultText.text = "So sorry! You rolled a 1. Try again!"
            2 -> resultText.text = "Sadly, you rolled a 2. Try again!"
            3 -> resultText.text = "Unfortunately, you rolled a 3. Try again!"
            4 -> resultText.text = "Don't cry! You rolled a 4. Try again!"
            6 -> resultText.text = "Apologies! You rolled a 6. Try again!"
            else -> "Isn't the lucky number"
        }
    }
}