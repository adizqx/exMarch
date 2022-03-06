package com.example.exmarch.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.exmarch.App
import com.example.exmarch.Entities.CategoryEntity
import com.example.exmarch.Entities.UslugaEntity
import com.example.exmarch.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    lateinit var binding: FragmentThirdBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentThirdBinding.inflate(inflater, container, false)

        val category = mutableListOf(CategoryEntity(1, "Internet"), CategoryEntity(2, "Komunalka"))

        val adapterCategory = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            category
        )
        binding.spinnerCategory.adapter = adapterCategory
        binding.spinnerCategory.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {}

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val category = category[position]
                    binding.addCategoryBtn.setOnClickListener {
                        App.instance?.getDatabase()?.Category()?.addCategory(category)
                        Log.i("GetAllCategory","${App.instance?.getDatabase()?.Category()?.getAllCategory()}")

                        val usluga = mutableListOf(UslugaEntity(0,"Aknet",category.id),
                            UslugaEntity(0,"MegaLine",category.id),
                            UslugaEntity(0,"CityNet",category.id),
                            UslugaEntity(0,"HomeLine",category.id),
                            UslugaEntity(0,"SaimaTelecom",category.id),
                            UslugaEntity(0,"СеверЭлектро",category.id),
                            UslugaEntity(0,"БишкекГаз",category.id),
                            UslugaEntity(0,"Домофон",category.id),
                            UslugaEntity(0,"БишкекТеплоСеть",category.id),
                            UslugaEntity(0,"Тазалык",category.id))

                        val adapterUsluga = ArrayAdapter(
                            requireContext(),
                            android.R.layout.simple_spinner_item,
                            usluga
                        )
                        binding.spinnerUsluga.adapter = adapterUsluga
                        binding.spinnerUsluga.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {
                                override fun onNothingSelected(parent: AdapterView<*>?) {}

                                override fun onItemSelected(
                                    parent: AdapterView<*>?,
                                    view: View?,
                                    position: Int,
                                    id: Long
                                ) {
                                    val usluga = usluga[position]
                                    binding.addUslugaBtn.setOnClickListener {
                                        App.instance?.getDatabase()?.Usluga()?.addUsluga(usluga)
                                        Log.i("GetAllUsluga","${App.instance?.getDatabase()?.Usluga()?.getAllUsluga()}")
                                    }
                                }
                            }


                    }
                }
            }





        return binding.root
    }


}