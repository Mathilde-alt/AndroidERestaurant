package fr.isen.jean.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.jean.androiderestaurant.databinding.ActivityCategoryBinding
import fr.isen.jean.androiderestaurant.model.DataResult
import fr.isen.jean.androiderestaurant.model.Items
import org.json.JSONObject

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCategoryBinding
    //private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.categoryTitle.text = intent.getStringExtra("category") ?: ""

        binding.categoryRecyclerVIew.layoutManager = LinearLayoutManager(this)
        binding.categoryRecyclerVIew.adapter = CategoryAdapter(arrayListOf()){
            startActivity(Intent(this, DetailActivity::class.java))
        }
        intent.getStringExtra("category")?.let { getDishFromServer(it) }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true

    }

    private fun getDishFromServer(type : String) {
        val queue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"
        var dish : ArrayList<String>

        val body = JSONObject().apply {
            put("id_shop", 1)
        }
        val request = JsonObjectRequest(
            Request.Method.POST, url, body,
            { response ->
                Log.d("CategoryActivity","ca marche")
                val data = Gson().fromJson(response.toString(), DataResult::class.java)
                println(type)
                when(type) {
                    "Entrées" -> { dish = data.data[0].items.map { it.nameEn ?: "" }.toList() as ArrayList
                        (binding.categoryRecyclerVIew.adapter as CategoryAdapter).updateDishes(dish)
                    println(type)}
                    "Plats" -> { dish = data.data[1].items.map { it.nameEn ?: "" }.toList() as ArrayList
                        (binding.categoryRecyclerVIew.adapter as CategoryAdapter).updateDishes(dish) }
                    "Desserts" -> { dish = data.data[2].items.map { it.nameEn ?: "" }.toList() as ArrayList
                        (binding.categoryRecyclerVIew.adapter as CategoryAdapter).updateDishes(dish)}
                }
            },
            { error ->
                Log.d("CategoryActivity","404 error")
            })
        queue.add(request)
    }
}
