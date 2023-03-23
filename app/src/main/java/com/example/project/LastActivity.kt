package com.example.project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_last.*

class LastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        val actionbar=supportActionBar
        actionbar!!.title="Order Confirmation"



        val bContinue = findViewById<Button>(R.id.btnContinue)
        bContinue.setOnClickListener()
        {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
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