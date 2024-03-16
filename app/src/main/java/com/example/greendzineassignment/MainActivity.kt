package com.example.greendzineassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.greendzineassignment.databinding.ActivityMainBinding
import java.time.Duration

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Find the login button using View Binding
        val loginButton: Button = binding.loginBtn
        val email= findViewById<EditText>(R.id.email)
        val password =  findViewById<EditText>(R.id.password)

        val emailValidator = "test@gmail.com"
        val passwordValidator = "test@01"

        loginButton.setOnClickListener{

            Log.d("Email", email.text.toString())
            Log.d("Pass", password.text.toString())
            if(email.text.toString() == emailValidator && password.text.toString()==passwordValidator) {
                val Intent = Intent(this, MainActivity2::class.java)
                startActivity(Intent)
            }
             else {
                 Toast.makeText(this, "E-mail or Password is incorrect", Toast.LENGTH_SHORT).show()
            }

        }


    }





}