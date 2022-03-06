package com.example.exmarch.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.exmarch.Entities.CategoryEntity
import com.example.exmarch.Fragments.FirstFragmentDirections
import com.example.exmarch.R

class CategoryAdapter(var array: List<CategoryEntity>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categoryName: TextView = itemView.findViewById(R.id.categoryNameTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = array[position]
        holder.categoryName.text = item.categoryName

        holder.itemView.setOnClickListener {

            val action = FirstFragmentDirections.actionFirstFragmentToUslugaRvFragment(item)
                  holder.itemView.findNavController().navigate(action)
        }
    }


    override fun getItemCount(): Int {
        return array.size
    }
}