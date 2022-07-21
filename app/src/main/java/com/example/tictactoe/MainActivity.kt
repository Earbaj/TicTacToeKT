package com.example.tictactoe

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //variable
    var activePlayer:Int = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var player1WinsCounts = 0
    var player2WinsCounts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Healper function for all click
    fun btnclick(view:View){
        val selected = view as Button
        var celId = 0
        when(selected.id){
            R.id.btn1 -> celId = 1
            R.id.btn2 -> celId = 2
            R.id.btn3 -> celId = 3
            R.id.btn4 -> celId = 4
            R.id.btn5 -> celId = 5
            R.id.btn6 -> celId = 6
            R.id.btn7 -> celId = 7
            R.id.btn8 -> celId = 8
            R.id.btn9 -> celId = 9
        }
        Log.d("Button selected", selected.id.toString())
        Log.d("Button celid", celId.toString())
        playGame(celId, selected)

    }

    //Helper function for gameplay
    fun playGame(cellId:Int, btnselected:Button){
        if (activePlayer == 1){
            btnselected.text = "X"
            btnselected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activePlayer = 2
        }else{
            btnselected.text = "O"
            btnselected.setBackgroundResource(R.color.orange)
            player2.add(cellId)
            activePlayer = 1
        }
        btnselected.isEnabled = false
        checkWinner()
    }
    fun checkWinner() {

        var winer = -1


        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }


        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }


        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }


        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }


        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }



        if (winer == 1) {
            player1WinsCounts += 1
            Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()

        } else if (winer == 2) {
            player2WinsCounts += 1
            Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
        }


    }
}