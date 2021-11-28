package com.example.xando

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        restartGame()

    }

    fun buClick(view: View) {
        val buSelected = view as Button
        var cellID = 0
        when (buSelected.id) {
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }
        playGame(cellID, buSelected)

    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellID: Int, buSelected: Button) {
        if (activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.Custom_color_secondary)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()

        } else {
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.darkGreen)
            player2.add(cellID)
            activePlayer = 1

        }
        buSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }


        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }


        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }


        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }


        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }


        // slant 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }


        // slant 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        // To determine the winner

      //  player1Count.setText("${player1Count.getText().toInt() + 5})
       // val player1Count = TextView(this)
       // val player2Count = TextView(this)




        //  var player1ScoreCount:Int =0
      //  var player2ScoreCount:Int =0

        if (winner == 1) {
            player1WinCount += 1
          //  player1Count+=1

            Toast.makeText(this, "Player1 wins the game... Cheers", Toast.LENGTH_LONG).show()
           restartGame()
        } else if (winner == 2) {
            player2WinCount += 1
         //   player2Count+=1
            Toast.makeText(this, "Player2 wins the game... Cheers", Toast.LENGTH_LONG).show()
            restartGame()
        }


    }
   // var player1Count:TextView= findViewById(R.id.player1Count)
  //  var player2Count:TextView= findViewById(R.id.player2Count)



    fun autoPlay() {
        val emptyCells = ArrayList<Int>()
        for (cellID in 1..9) {
            if (!(player1.contains(cellID)) || player2.contains(cellID))
                emptyCells.add(cellID)

        }
        if (emptyCells.size == 0) {
            restartGame()
        }
        val bu1: Button = findViewById(R.id.bu1)
        val bu2: Button = findViewById(R.id.bu2)
        val bu3: Button = findViewById(R.id.bu3)
        val bu4: Button = findViewById(R.id.bu4)
        val bu5: Button = findViewById(R.id.bu5)
        val bu6: Button = findViewById(R.id.bu6)
        val bu7: Button = findViewById(R.id.bu7)
        val bu8: Button = findViewById(R.id.bu8)
        val bu9: Button = findViewById(R.id.bu9)
        val random = Random()
        val randomIndex = random.nextInt(emptyCells.size)
        val cellID = emptyCells[randomIndex]
        val buSelected: Button = when (cellID) {
            1 -> bu1
            2 -> bu2
            3 -> bu3
            4 -> bu4
            5 -> bu5
            6 -> bu6
            7 -> bu7
            8 -> bu8
            9 -> bu9
            else -> bu1
        }
        playGame(cellID, buSelected)

    }

    var player1WinCount = 0
    var player2WinCount = 0

    // to reset the game
    fun restartGame() {
        val bu1: Button = findViewById(R.id.bu1)
        val bu2: Button = findViewById(R.id.bu2)
        val bu3: Button = findViewById(R.id.bu3)
        val bu4: Button = findViewById(R.id.bu4)
        val bu5: Button = findViewById(R.id.bu5)
        val bu6: Button = findViewById(R.id.bu6)
        val bu7: Button = findViewById(R.id.bu7)
        val bu8: Button = findViewById(R.id.bu8)
        val bu9: Button = findViewById(R.id.bu9)
        val reset: Button = findViewById(R.id.reset)
        reset.setOnClickListener {
            activePlayer = 1
            player1.clear()
            player2.clear()
            for (cellID in 1..9) {
                val buSelected: Button = when (cellID) {
                    1 -> bu1
                    2 -> bu2
                    3 -> bu3
                    4 -> bu4
                    5 -> bu5
                    6 -> bu6
                    7 -> bu7
                    8 -> bu8
                    9 -> bu9
                    else -> bu1
                }
                buSelected.text = ""
                buSelected.setBackgroundResource(R.color.whileBu)
                buSelected.isEnabled = true
            }
            Toast.makeText(this, "Player1: $player1WinCount && Player2: $player2WinCount", Toast.LENGTH_LONG).show()
        }
    }
}


