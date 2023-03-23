package com.example.project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.project.databinding.ActivityMain4Binding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_sign_in.*

class MainActivity4 : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain4Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain4.toolbar)

        //Floating button to make a call
        binding.appBarMain4.fab.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel://(051278601)"))
            startActivity(intent)
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the menu; this adds items to the action bar if it is present.
            menuInflater.inflate(R.menu.menufile, menu)
            return true
        }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
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