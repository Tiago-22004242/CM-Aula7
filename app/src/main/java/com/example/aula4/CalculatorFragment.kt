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

    fun adicionarDisplay() {
        binding.textVisor.text = Calculator.display
    }
    override fun onStart() {
        super.onStart()
        adicionarDisplay()
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Calculadora"
        binding.button1.setOnClickListener {onClickSymbol("1")}
        binding.button2.setOnClickListener {onClickSymbol("2")}
        binding.button3.setOnClickListener {onClickSymbol("3")}
        binding.button4.setOnClickListener {onClickSymbol("4")}
        binding.button5.setOnClickListener {onClickSymbol("5")}
        binding.button6.setOnClickListener {onClickSymbol("6")}
        binding.button7.setOnClickListener {onClickSymbol("7")}
        binding.button8.setOnClickListener {onClickSymbol("8")}
        binding.button9.setOnClickListener {onClickSymbol("9")}
        binding.buttonSum.setOnClickListener{onClickSymbol("+")}
        binding.buttonSubtration.setOnClickListener{onClickSymbol("-")}
        binding.buttonMul.setOnClickListener{onClickSymbol("*")}
        binding.buttonDivision.setOnClickListener{onClickSymbol("/")}
        binding.buttonDot.setOnClickListener{onClickSymbol(".")}
        binding.buttonClear.setOnClickListener{onClickClear()}
        binding.buttonLast.setOnClickListener{onClickLast()}
        binding.buttonDelete1.setOnClickListener{onClickDel()}
        binding.buttonEquals.setOnClickListener{onClickEquals()}
    }
    private fun onClickSymbol(symbol : String) {
        Log.i(TAG, "Click no botão $symbol")
        Calculator.addSymbol(symbol)
        adicionarDisplay()
    }
    private fun onClickClear() {
        Log.i(TAG, "Click no botão clear")
        Calculator.clear()
        adicionarDisplay()
    }
    private fun onClickLast() {
        Log.i(TAG, "Click no botão last")
        Calculator.last()
        adicionarDisplay()
    }
    private fun onClickDel() {
        Log.i(TAG, "Click no botão del")
        Calculator.backspace()
        adicionarDisplay()
    }
    private fun onClickEquals() {
        Log.i(TAG, "Click no botão =")
        Calculator.equals()
        adicionarDisplay()
        Log.i(TAG, "O resultado da expressão é ${binding.textVisor.text}")
    }
}


