package com.example.kalkulatorsederhana

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulatorsederhana.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun add(view: View) {
        calculate { num1, num2 -> num1 + num2 }
    }

    fun subtract(view: View) {
        calculate { num1, num2 -> num1 - num2 }
    }

    fun multiply(view: View) {
        calculate { num1, num2 -> num1 * num2 }
    }

    fun divide(view: View) {
        val num2 = binding.editTextNumber2.text.toString().toDouble()
        if (num2 != 0.0) {
            calculate { num1, num2 -> num1 / num2 }
        } else {
            binding.resultTextView.text = "Tidak bisa dibagi oleh 0"
        }
    }

    private fun calculate(operation: (Double, Double) -> Double) {
        val num1 = binding.editTextNumber1.text.toString().toDouble()
        val num2 = binding.editTextNumber2.text.toString().toDouble()
        val result = operation(num1, num2)
        binding.resultTextView.text = "Hasil: $result"
    }
}
