package com.example.project

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Order : AppCompatActivity() {
    private val CHANNELID  ="id for notification"
    private val notificationId = 101
    private var count:Int=0;
    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val actionbar=supportActionBar
        actionbar!!.title="Place Order"

        actionbar.setDisplayHomeAsUpEnabled(true)


        val etorderDate = findViewById<TextView>(R.id.etorderDate)
        val df: SimpleDateFormat = SimpleDateFormat("EEE, d MMM yyyy")
        val date: String = df.format(Calendar.getInstance().getTime())
        etorderDate.setText(date);
        val etorderId = findViewById<TextView>(R.id.etorderId)
        fun randomID(): String = List(8) {
            ('0'..'9').random()
        }.joinToString("")
        etorderId.setText("OD".plus(randomID()))
        val etdecharge = findViewById<TextView>(R.id.etdecharge)
        etdecharge.setText("Rs.25");
        val bConfirmOrder = findViewById<Button>(R.id.btnConfirmOrder)
        createNotificationChannel()
        val foodsData = intent
        val foodsName = foodsData.getStringExtra("foodsName")
        val foodsInfo = foodsData.getStringExtra("foodsInfo")
        val etproduct = findViewById<TextView>(R.id.etproduct)
        val etamount = findViewById<TextView>(R.id.etamount)
        etproduct.setText(foodsName)
        etamount.setText(foodsInfo)
        bConfirmOrder.setOnClickListener()
        {
            val intent= Intent(this,LastActivity::class.java)
            startActivity(intent)
            sendNotification()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val name = "Order Confirmation Notification"
        val descriptionText = "Food Ordered"
        val importance = NotificationManager.IMPORTANCE_DEFAULT

        val channel = NotificationChannel(CHANNELID,name,importance).apply {
            description = descriptionText
        }

        val notificationManager = getSystemService (NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
    private fun sendNotification() {
        val builder = NotificationCompat.Builder(this, CHANNELID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Order Confirmation Notification")
            .setContentText("You have successfully ordered food from deliciouso.Your order is on the way. Be ready with the order amount!!")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("You have successfully ordered food from deliciouso.Your order is on the way. Be ready with the order amount!!"))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(this)){
            notify(notificationId, builder.build())
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