package com.example.aula4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.aula4.databinding.FragmentCalculatorBinding
import com.example.aula4.models.Calculator
import com.example.aula4.models.Operation
import net.objecthunter.exp4j.ExpressionBuilder


class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private val TAG = MainActivity::class.java.simpleName
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_calculator, container, false
        )
        binding = FragmentCalculatorBinding.bind(view)
        return binding.root
    }
    val operacoes : MutableList<Operation> = mutableListOf()
    val calculadora : Calculator = Calculator()

    fun adicionarDisplay() {
        binding.textVisor.text = calculadora.display
    }
    override fun onStart() {
        super.onStart()
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Calculadora"
        binding.button1.setOnClickListener {
            Log.i(TAG, "Click no botão 1")
            calculadora.addSymbol("1")
            adicionarDisplay()
        }
        binding.button2.setOnClickListener {
            Log.i(TAG, "Click no botão 2")
            calculadora.addSymbol("2")
            adicionarDisplay()
        }
        binding.button3.setOnClickListener {
            Log.i(TAG, "Click no botão 3")
            calculadora.addSymbol("3")
            adicionarDisplay()
        }
        binding.button4.setOnClickListener {
            Log.i(TAG, "Click no botão 4")
            calculadora.addSymbol("4")
            adicionarDisplay()
        }
        binding.button5.setOnClickListener {
            Log.i(TAG, "Click no botão 5")
            calculadora.addSymbol("5")
            adicionarDisplay()
        }
        binding.button6.setOnClickListener {
            Log.i(TAG, "Click no botão 6")
            calculadora.addSymbol("6")
            adicionarDisplay()
        }
        binding.button7.setOnClickListener {
            Log.i(TAG, "Click no botão 7")
            calculadora.addSymbol("7")
            adicionarDisplay()
        }
        binding.button8.setOnClickListener {
            Log.i(TAG, "Click no botão 8")
            calculadora.addSymbol("8")
            adicionarDisplay()
        }
        binding.button9.setOnClickListener {
            Log.i(TAG, "Click no botão 9")
            calculadora.addSymbol("9")
            adicionarDisplay()
        }
        binding.buttonSum.setOnClickListener{
            Log.i(TAG, "Click no botão +")
            calculadora.addSymbol("+")
            adicionarDisplay()
        }
        binding.buttonSubtration.setOnClickListener{
            Log.i(TAG, "Click no botão -")
            calculadora.addSymbol("-")
            adicionarDisplay()
        }
        binding.buttonMul.setOnClickListener{
            Log.i(TAG, "Click no botão *")
            calculadora.addSymbol("*")
            adicionarDisplay()
        }
        binding.buttonDivision.setOnClickListener{
            Log.i(TAG, "Click no botão /")
            calculadora.addSymbol("/")
            adicionarDisplay()
        }
        binding.buttonDot.setOnClickListener{
            Log.i(TAG, "Click no botão .")
            calculadora.addSymbol(".")
            adicionarDisplay()
        }
        binding.buttonClear.setOnClickListener{
            Log.i(TAG, "Click no botão clear")
            calculadora.clear()
            adicionarDisplay()
        }
        binding.buttonLast.setOnClickListener{
            Log.i(TAG, "Click no botão last")
            calculadora.last()
            adicionarDisplay()
        }
        binding.buttonDelete1.setOnClickListener{
            Log.i(TAG, "Click no botão del")
            calculadora.backspace()
            adicionarDisplay()
        }
        binding.buttonEquals.setOnClickListener{
            Log.i(TAG, "Click no botão =")
            calculadora.equals()
            adicionarDisplay()
            Log.i(TAG, "O resultado da expressão é ${binding.textVisor.text}")
        }
    }
}


