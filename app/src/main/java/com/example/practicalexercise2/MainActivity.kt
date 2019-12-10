package com.example.practicalexercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var BMIImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BMIImage = findViewById(R.id.imageViewProfile)

        buttonCalculate.setOnClickListener{
            calculateBMI()
        }

        buttonReset.setOnClickListener {
            resetInput()
        }
    }

    private fun calculateBMI() {
        val getHeight: EditText = findViewById(R.id.editTextHeight)
        val getWeight: EditText = findViewById(R.id.editTextWeight)

        //result calculated bmi
        val viewBMI : TextView = findViewById(R.id.textViewBMI)

        val heightt = getHeight.text.toString().toDouble()
        val weight = getWeight.text.toString().toDouble()

        //calculate the bmi
        val height: Double = heightt/100
        val resultBMI: Double = weight/(height*height)

        val BMI = String.format("%.1f",resultBMI)

        viewBMI.setText("BMI :"+ String.format(BMI))

        //image
        if(resultBMI < 18.5){
            BMIImage.setImageResource(R.drawable.under)
        }else if(resultBMI > 24.9){
            BMIImage.setImageResource(R.drawable.over)
        }else if(resultBMI >= 18.5 || resultBMI <= 24.9){
            BMIImage.setImageResource(R.drawable.normal)
        }
    }

    fun resetInput() {
        val edit1: EditText = findViewById(R.id.editTextHeight)
        val edit2: EditText = findViewById(R.id.editTextWeight)
        val text1 : TextView = findViewById(R.id.textViewBMI)

        edit1.text.clear()
        edit2.text.clear()
        BMIImage.setImageResource(R.drawable.empty)
        text1.setText("BMI :")
    }
}