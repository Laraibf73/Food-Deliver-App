package com.example.project.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.project.R
import com.example.project.SignIn
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    private lateinit var editTextPersonName:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val actionbar=supportActionBar
        actionbar!!.title="Item"

        actionbar.setDisplayHomeAsUpEnabled(true)

        val foodsData=intent
        val foodsName=foodsData.getStringExtra("foodsName")
        val foodsInfo=foodsData.getStringExtra("foodsInfo")
        val foodsImg=foodsData.getIntExtra("foodsImg",0)
        imgF.setImageResource(foodsImg)
        foodName.text=foodsName
        foodInfo.text=foodsInfo
        editTextPersonName=findViewById(R.id.editTextPersonName)
        ADDCART.setOnClickListener()
        {
            var foodsIntent = Intent(this, Cart::class.java)
            foodsIntent.putExtra("foodsName", foodsName)
            foodsIntent.putExtra("foodsInfo", foodsInfo)
            foodsIntent.putExtra("foodsQty", editTextPersonName.text.toString())
            foodsIntent.putExtra("foodsImg", foodsImg)

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

        }  else if (id == R.id.cart) {

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
