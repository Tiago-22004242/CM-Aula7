package com.example.aula4

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.aula4.databinding.ActivityMainBinding
private val TAG = MainActivity::class.java.simpleName
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "o método onCreate foi invocado")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Se o ecrã rodar, não vai para o CalculatorFragment (permanece no
        // Fragmento onde estava anteriormente.
        if(!screenRotated(savedInstanceState)) {
            NavigationManager.goToCalculatorFragment(supportFragmentManager)
        }
    }
    override fun onStart() {
        super.onStart()
        setSupportActionBar(binding.toolbar)
        setupDrawerMenu()
    }
    private fun screenRotated(savedInstanceState: Bundle?): Boolean {
        return savedInstanceState != null
    }

    private fun setupDrawerMenu() {
        val toggle = ActionBarDrawerToggle(this,
            binding.drawer, binding.toolbar,
            R.string.drawer_open, R.string.drawer_close
        )
        binding.navDrawer.setNavigationItemSelectedListener{
            onClickNavigationItem(it)
        }
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()
    }
    private fun onClickNavigationItem(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_calculator ->
                NavigationManager.goToCalculatorFragment(
                    supportFragmentManager
                )
            R.id.nav_history ->
                NavigationManager.goToHistoryFragment(
                    supportFragmentManager
                )
        }
        binding.drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START)
        } else if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
    override fun onDestroy() {
        Log.i(TAG, "o método onDestroy foi invocado")
        super.onDestroy()
    }
}