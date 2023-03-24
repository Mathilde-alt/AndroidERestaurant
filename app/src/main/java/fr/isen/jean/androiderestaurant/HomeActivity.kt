package fr.isen.jean.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import fr.isen.jean.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.starters.setOnClickListener {
            Log.d("activity_home","Vous avez cliqué sur le bouton entrées")
            Toast.makeText(this, "vous avez cliqué sur le bouton entrées",Toast.LENGTH_SHORT)
            val intent = Intent(this,CategoryActivity::class.java)
            intent.putExtra("category","Entrées")
            startActivity(intent)
        }

        binding.dishes.setOnClickListener {
            Log.d("activity_home","Vous avez cliqué sur le bouton plats")
            Toast.makeText(this, "vous avez cliqué sur le bouton plats",Toast.LENGTH_SHORT)
            val intent = Intent(this,CategoryActivity::class.java)
            intent.putExtra("category","Plats")
            startActivity(intent)
        }

        binding.desserts.setOnClickListener {
            Log.d("activity_home","Vous avez cliqué sur le bouton desserts")
            Toast.makeText(this, "vous avez cliqué sur le bouton desserts",Toast.LENGTH_SHORT)
            val intent = Intent(this,CategoryActivity::class.java)
            intent.putExtra("category","Desserts")
            startActivity(intent)
        }
    }
}



