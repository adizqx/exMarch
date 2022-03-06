package com.example.exmarch

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.exmarch.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
const val PREF_FILE = "PrefFile"
const val APP_PREF_LOGIN = "Login"
const val APP_PREF_PASSWORD = "Password"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: android.content.SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = this.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)

        val currentLoginValue = preferences.getString(APP_PREF_LOGIN, "")
        val currentPasswordValue = preferences.getString(APP_PREF_PASSWORD, "")

        binding.editTextLogin.setText(currentLoginValue)
        binding.editTextPass.setText(currentPasswordValue)

        binding.buttonEnter.setOnClickListener {
            val loginValue = binding.editTextLogin.text.toString()
            val passwordValue = binding.editTextPass.text.toString()
            preferences.edit().putString(APP_PREF_LOGIN, loginValue).apply()
            preferences.edit().putString(APP_PREF_PASSWORD, passwordValue).apply()

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }



}