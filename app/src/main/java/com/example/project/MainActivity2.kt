package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Hiding Title bar and displaying full screen 
        requestWindowFeature(Window.FEATURE_NO_TITLE) //will hide the title
        getSupportActionBar()?.hide() // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN) //enable full screen

        setContentView(R.layout.activity_main2)

        //Next Button
        NextBtn.setOnClickListener {
            val intent= Intent(this,SignIn::class.java)
            startActivity(intent)

        }
    }
}