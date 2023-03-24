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
import fr.isen.jean.androiderestaurant.databinding.ActivityCategoryBinding
import org.json.JSONObject

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* binding.CategoryTitle.text =
            intent.getStringExtra("category") ?: supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val platList = resources.getStringArray(R.array.liste_plats).toList() as ArrayList
        val platRecyclerView = findViewById<RecyclerView>(R.id.ListePlats)
        platRecyclerView.layoutManager = LinearLayoutManager(this)
        platRecyclerView.adapter = PlatAdapter(platList)  //platList = dishes

        startActivity(Intent(this, DetailActivity::class.java))*/
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true

    }

    private fun getDishFromServer() {
        val queue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val body = JSONObject().apply {
            put("id_shop", 1)
        }
        val request = JsonObjectRequest(
            Request.Method.POST, url, body,
            { response ->
                Log.d("CategoryActivity","ca marche")
                /*val data = Gson().fromJson(response.toString(), DataResult::class.java)

                val platList = data.data[0].items.map { it.categNameFr ?: ...}*/

            },
            { error ->
                Log.d("CategoryActivity","404 error")
            })
        queue.add(request)
    }
}
