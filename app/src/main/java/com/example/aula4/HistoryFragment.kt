package com.example.aula4

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aula4.databinding.FragmentHistoryBinding
import com.example.aula4.models.Calculator

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_history, container, false
        )
        binding = FragmentHistoryBinding.bind(view)
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Historico"
        val builder = StringBuilder()
        val history = Calculator.history
        history.forEach {builder.append("${it.expression}=${it.result}\n")}
        binding.tvHistory.text = builder.toString()
    }
}