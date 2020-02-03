package com.rightwinds.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

const val KEY_DIE1 = "key_die1"
const val KEY_DIE2 = "key_die2"

class MainActivity : AppCompatActivity() {

    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView
    private var storedDie1 = (R.drawable.empty_dice)
    private var storedDie2 = (R.drawable.empty_dice)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage1 = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton: Button = findViewById(R.id.btn_roll)
        rollButton.setOnClickListener { rollDice() }
        val clearButton: Button = findViewById(R.id.btn_clear)
        clearButton.setOnClickListener { clear() }

        if (savedInstanceState != null) {
            storedDie1 = savedInstanceState.getInt(KEY_DIE1)
            storedDie2 = savedInstanceState.getInt(KEY_DIE2)
        }

        diceImage1.setImageResource(storedDie1)
        diceImage2.setImageResource(storedDie2)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_DIE1, storedDie1)
        outState.putInt(KEY_DIE2, storedDie2)
    }

    private fun rollDice() {
        storedDie1 = getRandomDiceImage()
        storedDie2 = getRandomDiceImage()
        diceImage1.setImageResource(storedDie1)
        diceImage2.setImageResource(storedDie2)
    }


    private fun getRandomDiceImage() : Int {

        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun clear() {
        diceImage1.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
        storedDie1 = (R.drawable.empty_dice)
        storedDie2 = (R.drawable.empty_dice)
    }
}
