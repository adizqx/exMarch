package com.example.exmarch.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.exmarch.App
import com.example.exmarch.Entities.UslugaEntity
import com.example.exmarch.Fragments.UslugaRvFragmentDirections
import com.example.exmarch.R

class UslugaAdapter(var array: List<UslugaEntity>, val context: Context ,private val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<UslugaAdapter.UslugaViewHolder>() {
    class UslugaViewHolder(itemView: View,onItemClickListener: OnItemClickListener): RecyclerView.ViewHolder(itemView) {
        val uslugaName: TextView = itemView.findViewById(R.id.uslugaNameTv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UslugaViewHolder {
        return UslugaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_usluga, parent, false),onItemClickListener
        )
    }

    override fun onBindViewHolder(holder: UslugaViewHolder, position: Int) {
        val item = array[position]
        holder.uslugaName.text = item.uslugaName
       holder.itemView.setOnClickListener {  onItemClickListener.onClick(item) }


    }

    override fun getItemCount(): Int {
        return array.size
    }
    interface OnItemClickListener {
        fun onClick(item: UslugaEntity)
    }
}


