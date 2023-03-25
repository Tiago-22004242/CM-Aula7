package com.example.aula4.models

import net.objecthunter.exp4j.ExpressionBuilder

class Calculator {
    var display : String = "0"
        private set
    private val _history = mutableListOf<Operation>(
        Operation("1+1", "2"), Operation("2+2", "4")
    )
    val history get() = _history.toList()

    fun addSymbol(symbol: String) {
        if (display == "0") {
            display = symbol
        } else {
            display += symbol
        }
    }
    fun equals() {
        val expression = ExpressionBuilder(
            display
        ).build()
        val resultado = expression.evaluate().toString()
        display = resultado
        _history.add(Operation(expression.toString(),resultado))
    }
    fun backspace() {
        val expressao = display.length - 1
        if ( expressao > 0) {
            display =  display.substring(0,expressao)
        } else {
            display = "0"
        }
    }
    fun last() {
        if (_history.isNotEmpty()) {
            display = _history.last().result
        }
    }
    fun clear() {
        display = "0"
    }
}