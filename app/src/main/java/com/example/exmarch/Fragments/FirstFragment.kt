package com.example.exmarch.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.exmarch.Adapter.CategoryAdapter
import com.example.exmarch.App

import com.example.exmarch.R
import com.example.exmarch.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = App.instance?.getDatabase()?.Category()

        binding.recyclerViewCategory.adapter = CategoryAdapter(db!!.getAllCategory())
        binding.recyclerViewCategory.layoutManager = GridLayoutManager(context,3)
    }


}