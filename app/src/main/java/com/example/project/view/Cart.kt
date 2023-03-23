package com.example.project.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.Order
import com.example.project.R
import com.example.project.SignIn
import kotlinx.android.synthetic.main.activity_cart.*

class Cart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val actionbar=supportActionBar
        actionbar!!.title="Cart"

        actionbar.setDisplayHomeAsUpEnabled(true)

        val foodsData = intent
        val foodsName = foodsData.getStringExtra("foodsName")
        val foodsInfo = foodsData.getStringExtra("foodsInfo")
        val foodsQty = foodsData.getStringExtra("foodsQty")
        val foodsImg = foodsData.getIntExtra("foodsImg", 0)



        val foodName = findViewById<TextView>(R.id.foodName)
        val foodInfo = findViewById<TextView>(R.id.foodInfo)
        val imgF = findViewById<ImageView>(R.id.imgF)
        imgF.setImageResource(foodsImg)
        foodName.text = foodsName
        foodInfo.text =foodsInfo
        tvqty.text = foodsQty
       totalvalue.text =foodsInfo + "+ Rs/25."
        PLACEORDER.setOnClickListener()
        {
            var foodsIntent = Intent(this, Order::class.java)
            foodsIntent.putExtra("foodsName", foodsName)
            foodsIntent.putExtra("foodsInfo", foodsInfo)
            startActivity(foodsIntent)
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menufile, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var id = item.getItemId();

        if (id == R.id.search) {
            Toast.makeText(this, "Search selected", Toast.LENGTH_SHORT).show()
        }
        else if (id == R.id.cart) {

            Toast.makeText(this, "Cart selected", Toast.LENGTH_SHORT).show()

        }else if (id == R.id.help) {

            Toast.makeText(this, "Help selected", Toast.LENGTH_SHORT).show()

        }
        else if (id == R.id.Email) {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:Deliciouso@gmail.com")
            }
            startActivity(Intent.createChooser(emailIntent, "Send feedback"))
        }
        else if (id == R.id.logout) {
            val i = Intent(this, SignIn::class.java)
            Toast.makeText(this, "LogOut selected", Toast.LENGTH_SHORT).show()
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }
}