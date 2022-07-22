package com.example.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnReset -> restartGame()
        }
        return super.onOptionsItemSelected(item)
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
            autoPlay()
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
            restartGame()

        } else if (winer == 2) {
            player2WinsCounts += 1
            Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
            restartGame()
        }

    }
    fun autoPlay(){


        var emptyCells = ArrayList<Int>()

        for( cellId in 1..9){

            if( !(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }



        if(emptyCells.size==0){
            restartGame()
        }


        val r = Random()
        val randIndex = r.nextInt(emptyCells.size )
        val cellId = emptyCells[randIndex]

        var buSelected:Button
        buSelected =  when(cellId){
            1-> btn1
            2-> btn2
            3-> btn3
            4-> btn4
            5-> btn5
            6-> btn6
            7-> btn7
            8-> btn8
            9-> btn9
            else ->{ btn1}

        }
        playGame(cellId, buSelected)
    }

    fun restartGame(){

        activePlayer = 1
        player1.clear()
        player2.clear()

        for(cellId in 1..9){

            var buSelected:Button? = when(cellId){
                1-> btn1
                2-> btn2
                3-> btn3
                4-> btn4
                5-> btn5
                6-> btn6
                7-> btn7
                8-> btn8
                9-> btn9
                else ->{ btn1}

            }
            buSelected!!.text = ""
            buSelected!!.setBackgroundResource(R.color.btnColor)
            buSelected!!.isEnabled = true
        }

        Toast.makeText(this,"Player1: $player1WinsCounts, Player2: $player2WinsCounts", Toast.LENGTH_LONG).show()


    }
}