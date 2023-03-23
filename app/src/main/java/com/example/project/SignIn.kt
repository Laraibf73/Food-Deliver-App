package com.example.project

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignIn : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //Hiding Title bar and displaying full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE) //will hide the title
        getSupportActionBar()?.hide() // hide the title bar
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ) //enable full screen

        setContentView(R.layout.activity_sign_in)

        //Shared preferences for storing email & password
        sharedPref = getSharedPreferences("SignIn", Context.MODE_PRIVATE)

        val intent = Intent(this, MainActivity4::class.java)


            //Sign in button
            SignInBtn.setOnClickListener {
                val editor = sharedPref.edit()
                editor.putString("email", EmailAddress.text.toString())
                editor.putString("password", password.text.toString())
                editor.apply()

                if (EmailAddress.text.trim().isNotEmpty() && password.text.trim().isNotEmpty()) {
                    //correct
                    Toast.makeText(this, "Signed_In Successfully!", Toast.LENGTH_SHORT).show()

                    startActivity(intent)

                }
                else {         //incorrect
           Toast.makeText(this, "Sign-in failed!", Toast.LENGTH_SHORT).show()
        }
    }

        SignUpBtn.setOnClickListener { view ->
            val i = Intent(this, com.example.project.SignUp::class.java)
            startActivity(i) }
    }
}


/*if (EmailAddress.getText().toString().equals("admin@gmail.com") && password.getText().toString().equals("admin")) {
           //correct
           Toast.makeText(this, "Signed_In Successfully!", Toast.LENGTH_SHORT).show()

           startActivity(intent)

        }*/