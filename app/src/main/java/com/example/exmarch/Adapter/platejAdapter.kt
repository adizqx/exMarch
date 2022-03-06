package com.example.exmarch.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exmarch.Entities.PlatejEntity
import com.example.exmarch.R

class platejAdapter(var array:List<PlatejEntity>): RecyclerView.Adapter<platejAdapter.platejViewHolder>() {
    class platejViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val platejName: TextView = itemView.findViewById(R.id.platejNameTv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): platejViewHolder {
        return platejViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_platej,parent,false))
    }

    override fun onBindViewHolder(holder: platejViewHolder, position: Int) {
        val item = array[position]
        holder.platejName.text = item.summa.toString()
    }

    override fun getItemCount(): Int {
        return array.size
    }
}