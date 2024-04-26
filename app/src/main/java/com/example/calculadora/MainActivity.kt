package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //0->nada; 1->suma; 2->resta; 3->multi; 4->division
    var num2: Double = 0.0;
    lateinit var txt_num2: TextView;
    lateinit var txt_num1: TextView;
    var operacion : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_num1 = findViewById(R.id.txt_num1)
        txt_num2 = findViewById(R.id.txt_num2)
    }

    fun presionarNumero(view: View) {
        val num1: String = txt_num1.text.toString().toString()

        when (view.id) {
            R.id.btn_num0 -> txt_num1.setText(num1 + "0")
            R.id.btn_num1 -> txt_num1.setText(num1 + "1")
            R.id.btn_num2 -> txt_num1.setText(num1 + "2")
            R.id.btn_num3 -> txt_num1.setText(num1 + "3")
            R.id.btn_num4 -> txt_num1.setText(num1 + "4")
            R.id.btn_num5 -> txt_num1.setText(num1 + "5")
            R.id.btn_num6 -> txt_num1.setText(num1 + "6")
            R.id.btn_num7 -> txt_num1.setText(num1 + "7")
            R.id.btn_num8 -> txt_num1.setText(num1 + "8")
            R.id.btn_num9 -> txt_num1.setText(num1 + "9")
            R.id.btn_punto -> txt_num1.setText(num1 + ".")
        }
    }

    fun clicOperacion(view: View) {
        num2 = txt_num1.text.toString().toDouble()
        var num2: String = txt_num1.text.toString()
        txt_num1.setText("")
        when (view.id) {
            R.id.btn_suma -> {
                txt_num1.setText(num2 + "+")
                operacion = 1
            }

            R.id.btn_resta -> {
                txt_num1.setText(num2 + "-")
                operacion = 2
            }

            R.id.btn_multi -> {
                txt_num1.setText(num2 + "*")
                operacion = 3
            }

            R.id.btn_division -> {
                txt_num1.setText(num2 + "/")
                operacion = 4
            }


        }
    }
}