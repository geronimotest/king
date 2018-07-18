package com.kotlyntutorial

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.textView as theView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe(view : View){

        val myToast = Toast.makeText(this,"Hello toast",Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe(view : View){
       // val showCountTextView = findViewById<TextView>(R.id.textView)
        val countString = theView.text.toString()
        var count = 0
        try{
            count = Integer.parseInt(countString)
        }catch (e : NumberFormatException){

        }
        count++
        theView.text = count.toString()
    }


    fun randomMe (view: View) {
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)

        // Get the current value of the text view.
        val countString = theView.text.toString()

        // Convert the count to an int
        var count = 0
        try{
            count = Integer.parseInt(countString)
        }catch (e : NumberFormatException){

        }

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)

        // Start the new activity.
        startActivity(randomIntent)
    }
}
