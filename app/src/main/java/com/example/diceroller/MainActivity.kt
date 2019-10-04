package com.example.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    //val = constante
    //var = no constante
    private lateinit var rollButton: Button
    private lateinit var tvResult:   TextView
    private lateinit var diceImage: ImageView

    private var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollButton = findViewById(R.id.rollButton)
        tvResult   = findViewById(R.id.result_text)
        diceImage  = findViewById(R.id.dice_image)

        rollButton.setOnClickListener{rollDice()}

    }

    fun gotoRecycler(view: View){
        val intent = Intent(this,recycler::class.java)
        startActivity(intent)
    }

    private fun rollDice(){
        val randomInt = Random().nextInt(6) + 1
        tvResult.text = ""+randomInt

        val drawableResource = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        Toast.makeText(this,"button clicked",Toast.LENGTH_LONG).show()
    }
}
