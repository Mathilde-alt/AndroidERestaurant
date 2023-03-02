package fr.isen.jean.androiderestaurant

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import fr.isen.jean.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)

        val entree = findViewById<TextView>(R.id.Entrees)
        entree.setOnClickListener {
            val intent = Intent(this,CategoryActivity::class.java)
            startActivity(intent)
        }

        binding.starters.setOnClickListener {
            Log.d("activity_home","Vous avez cliqué sur le bouton")
            Toast.makeText(this, "vous avez cliqué sur le bouton",Toast.LENGTH_SHORT)
            val intent = Intent(this,CategoryActivity::class.java)
            intent.putExtra("category",getString(R.string.home_starters))
            startActivity(intent)
        }

        val dessert = findViewById<TextView>(R.id.Desserts)
        dessert.setOnClickListener {
            val intent = Intent(this,CategoryActivity::class.java)
            startActivity(intent)
        }
    }
}


