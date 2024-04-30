package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var txt_num1: TextView
    lateinit var txt_num2: TextView
    var resultadoAnterior: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_num1 = findViewById(R.id.txt_num1)
        txt_num2 = findViewById(R.id.txt_num2)
    }

    fun presionarNumero(view: View) {
        val buttonText = when (view.id) {
            R.id.btn_num0 -> "0"
            R.id.btn_num1 -> "1"
            R.id.btn_num2 -> "2"
            R.id.btn_num3 -> "3"
            R.id.btn_num4 -> "4"
            R.id.btn_num5 -> "5"
            R.id.btn_num6 -> "6"
            R.id.btn_num7 -> "7"
            R.id.btn_num8 -> "8"
            R.id.btn_num9 -> "9"
            R.id.btn_punto -> "."
            else -> ""
        }

        txt_num1.append(buttonText)
    }

    fun clicOperacion(view: View) {
        val operacion = when (view.id) {
            R.id.btn_suma -> "+"
            R.id.btn_resta -> "-"
            R.id.btn_multi -> "*"
            R.id.btn_division -> "/"
            else -> ""
        }

        if (resultadoAnterior != null) {
            txt_num1.text = resultadoAnterior.toString()
        }

        txt_num2.text = txt_num1.text.toString() + " " + operacion
        txt_num1.text = ""
    }

    fun calcularResultado(view: View) {
        val textoOperacion = txt_num2.text.toString()

        if (textoOperacion.isBlank()) {
            txt_num1.text = "0"
            txt_num2.text = ""
            return
        }

        try {
            val partes = textoOperacion.split(" ")
            val numero1 = partes[0].toDouble()
            val operador = partes[1]
            val numero2 = if (txt_num1.text.toString().isNotEmpty()){
                txt_num1.text.toString().toDouble()
            } else {
                0.0
            }

            if (operador == "/" && numero2 == 0.0){
                txt_num1.text = "No se puede div en cero"
                return
            }

            val resultado = when (operador) {
                "+" -> numero1 + numero2
                "-" -> numero1 - numero2
                "*" -> numero1 * numero2
                "/" -> numero1 / numero2
                else -> throw IllegalArgumentException("Operador no válido")
            }

            resultadoAnterior = resultado

            txt_num1.text = if (resultado.toInt().toDouble() == resultado) {
                resultado.toInt().toString()
            } else {
                resultado.toString()
            }
            txt_num2.text = ""
        } catch (e: Exception) {
            txt_num1.text = "Math error"
        }
    }


    fun borrarDigito(view: View) {
        val textoActual = txt_num1.text.toString()
        if (textoActual.isNotEmpty()) {
            txt_num1.text = textoActual.substring(0, textoActual.length - 1)
        }
    }

    fun borrarTodo(view: View) {
        txt_num1.text = ""
        txt_num2.text = ""
        resultadoAnterior = null
    }
}

