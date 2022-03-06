package com.example.exmarch.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exmarch.Adapter.UslugaAdapter
import com.example.exmarch.Adapter.platejAdapter
import com.example.exmarch.App
import com.example.exmarch.R
import com.example.exmarch.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = App.instance?.getDatabase()?.Platej()
        binding.recyclerViewPlatej.adapter = platejAdapter(db!!.getAllPlatej())
        binding.recyclerViewPlatej.layoutManager = LinearLayoutManager(context)
    }

}