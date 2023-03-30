package fr.isen.jean.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(var dishes: ArrayList<String>, val onDishClickListener: (String) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val dishename = view.findViewById<TextView>(R.id.dishename)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_cell, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val dish = dishes[position]
        holder.dishename.text = dish

        holder.itemView.setOnClickListener {
            onDishClickListener(dish)
        }
    }

    override fun getItemCount(): Int = dishes.size

    fun updateDishes(dishesFromAPI: ArrayList<String>){
        dishes = dishesFromAPI
        notifyDataSetChanged()
    }
}
