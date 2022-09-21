package com.eray.mvvmcontacts.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.eray.mvvmcontacts.R
import com.eray.mvvmcontacts.databinding.FragmentDetailPersonBinding
import com.eray.mvvmcontacts.ui.viewModel.DetailPersonViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailPersonFragment : Fragment() {

    private lateinit var binding: FragmentDetailPersonBinding
    private lateinit var viewModel: DetailPersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: DetailPersonViewModel by viewModels()
        viewModel=tempViewModel
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_detail_person,container,false)

        binding.personDetailFragment=this

        binding.toolbarDetail="Person Detail"


        val bundle:DetailPersonFragmentArgs by navArgs()
        var comingPersonInfo=bundle.person

       binding.personObject=comingPersonInfo



        return binding.root
    }

    fun buttonUpdatePerson(person_id:Int,person_name:String,person_tel:String){

       viewModel.personUpdate(person_id,person_name,person_tel)
    }

}