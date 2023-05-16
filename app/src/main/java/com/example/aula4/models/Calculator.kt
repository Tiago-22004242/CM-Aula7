package com.example.aula4.models

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder

object Calculator {
    var display : String = "0"
        private set
    private val _history = mutableListOf<Operation>(
        Operation("1+1", "2"), Operation("2+2", "4")
    )
    fun getHistory(callback: (List<Operation>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            Thread.sleep(3 * 1000)
            callback(_history.toList())
        }
    }
    fun addSymbol(symbol: String) {
        if (display == "0") {
            display = symbol
        } else {
            display += symbol
        }
    }
    fun equals(addedToHistory: () -> Unit) {
        val expression = ExpressionBuilder(
            display
        ).build()
        val resultado = expression.evaluate().toString()
        val expressao = display
        display = resultado
        CoroutineScope(Dispatchers.IO).launch {
            addToHistory(expressao,resultado)
            addedToHistory()
        }
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
    suspend fun addToHistory(expressao: String, resultado: String) {
        Thread.sleep(3 * 1000)
        _history.add(Operation(expressao,resultado))
    }
}