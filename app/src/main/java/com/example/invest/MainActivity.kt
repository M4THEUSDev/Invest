package com.example.invest

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    // Declare as variáveis para os componentes da interface
    private lateinit var txtNro1: EditText
    private lateinit var txtNro2: EditText
    private lateinit var txtNro3: EditText
    private lateinit var txtNro4: EditText
    private lateinit var resultado: TextView
    private lateinit var btnCalc: Button
    private lateinit var btnLimpa: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialize as variáveis com base nos IDs dos componentes
        txtNro1 = findViewById(R.id.txtNro1)
        txtNro2 = findViewById(R.id.txtNro2)
        txtNro3 = findViewById(R.id.txtNro3)
        txtNro4 = findViewById(R.id.txtNro4)
        resultado = findViewById(R.id.textCapital)
        btnCalc = findViewById(R.id.btncalc)
        btnLimpa = findViewById(R.id.btnLimpa)

        // Configurar um ouvinte de clique para o botão de cálculo
        btnCalc.setOnClickListener(View.OnClickListener {
            // Obter os valores dos campos de texto como strings
            val strNro1 = txtNro1.text.toString()
            val strNro2 = txtNro2.text.toString()
            val strNro3 = txtNro3.text.toString()
            val strNro4 = txtNro4.text.toString()

            // Converter as strings para números (se possível)
            val nro1 = strNro1.toDoubleOrNull()
            val nro2 = strNro2.toIntOrNull()
            val nro3 = strNro3.toDoubleOrNull()   // Converter a taxa de juros para decimal
            val nro4 = strNro4.toDoubleOrNull()

            // Verificar se a conversão foi bem-sucedida e se o número de meses é até 12
            if (nro1 != null && nro2 != null && nro3 != null && nro4 != null && nro2 <= 12) {

                val resultadoCalculo = nro1 * (1 + nro4).pow(nro2) + nro3 * ((1 + nro4).pow(nro2) - 1) / nro2

                // Exibir o resultado na TextView
                resultado.text = "Valor Futuro: $resultadoCalculo"
            } else {
                // Se a conversão falhou ou o número de meses é maior que 12, exibir uma mensagem de erro
                resultado.text = "Valores inválidos ou número de meses maior que 12"
            }
        })
        // Configurar um ouvinte de clique para o botão de limpar
                btnLimpa.setOnClickListener(View.OnClickListener {
                    // Limpar os campos de texto e a TextView de resultado
                    txtNro1.text.clear()
                    txtNro2.text.clear()
                    txtNro3.text.clear()
                    txtNro4.text.clear()
                    resultado.text = ""
                })
    }
}