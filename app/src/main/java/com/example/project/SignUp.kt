package com.example.project

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    private lateinit var sharedPref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Hiding Title bar and displaying full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE) //will hide the title
        getSupportActionBar()?.hide() // hide the title bar
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ) //enable full screen

        setContentView(R.layout.activity_sign_up)

        sharedPref=getSharedPreferences("Sign Up",Context.MODE_PRIVATE)
        val intent = Intent(this, SignIn::class.java)


        SignUp.setOnClickListener{
            val editor=sharedPref.edit()
            editor.putString("Username",UserName.text.toString())
            editor.putString("Email",emailaddress.text.toString())
            editor.putString("Password",UserPassword.text.toString())
            editor.apply()

            Toast.makeText(this,"Signup Successfully",Toast.LENGTH_SHORT).show()
            startActivity(intent)

        }
    }
}
/*
 val editor = sharedPref.edit()
                editor.putString("email", EmailAddress.text.toString())
                editor.putString("password", password.text.toString())
                editor.apply()
 */