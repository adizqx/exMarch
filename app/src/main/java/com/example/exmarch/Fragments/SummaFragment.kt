package com.example.exmarch.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.exmarch.App
import com.example.exmarch.Entities.PlatejEntity
import com.example.exmarch.R
import com.example.exmarch.databinding.FragmentSummaBinding


class SummaFragment : Fragment() {
    lateinit var binding: FragmentSummaBinding
    private val args by navArgs<SummaFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  FragmentSummaBinding.inflate(inflater, container, false)

        binding.categoryTv.setText(args.category.categoryName)
        binding.uslugaTv.setText(args.usluga.uslugaName)

        binding.payBtn.setOnClickListener {
            val summa = binding.etSumma.text.toString().toInt()
            val db = App.instance?.getDatabase()?.Platej()
            val summaEntity = PlatejEntity(args.category.id,args.usluga.id, summa)
            db!!.addPlatej(summaEntity)

            findNavController().navigate(R.id.action_summaFragment_to_secondFragment)
        }



        return  binding.root
    }

}