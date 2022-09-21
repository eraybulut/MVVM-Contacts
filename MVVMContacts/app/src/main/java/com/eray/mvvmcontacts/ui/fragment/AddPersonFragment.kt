package com.eray.mvvmcontacts.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.eray.mvvmcontacts.R
import com.eray.mvvmcontacts.databinding.FragmentAddPersonBinding
import com.eray.mvvmcontacts.ui.viewModel.AddPersonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddPersonFragment : Fragment() {

    private lateinit var binding: FragmentAddPersonBinding
    private lateinit var viewModel: AddPersonViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: AddPersonViewModel by viewModels()
        viewModel=tempViewModel
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_add_person,container,false)

        binding.addPersonFragment=this


        binding.toolbarTitle="Add Person"

        return binding.root
    }

    fun buttonaddPerson(personName:String,personTel:String){
       viewModel.save(personName,personTel)
    }
}