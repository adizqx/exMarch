package com.example.exmarch.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exmarch.Adapter.UslugaAdapter
import com.example.exmarch.App
import com.example.exmarch.Entities.UslugaEntity
import com.example.exmarch.databinding.FragmentUslugaRvBinding


class UslugaRvFragment : Fragment(),UslugaAdapter.OnItemClickListener {
    lateinit var binding: FragmentUslugaRvBinding
    private val args by navArgs<UslugaRvFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUslugaRvBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = App.instance?.getDatabase()?.Usluga()
        binding.recyclerViewUsluga.adapter = UslugaAdapter(db!!.getAllUsluga(),requireContext(),this)
        binding.recyclerViewUsluga.layoutManager = LinearLayoutManager(context)


    }

    override fun onClick(item: UslugaEntity) {
        val action = UslugaRvFragmentDirections.actionUslugaRvFragmentToSummaFragment(item,args.category1)
                findNavController().navigate(action)
    }

}