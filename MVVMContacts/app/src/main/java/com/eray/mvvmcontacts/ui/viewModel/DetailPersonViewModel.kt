package com.eray.mvvmcontacts.ui.viewModel

import androidx.lifecycle.ViewModel
import com.eray.mvvmcontacts.data.repo.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailPersonViewModel @Inject  constructor(var pRepo:PersonDaoRepository): ViewModel() {


    fun personUpdate(person_id:Int,person_name:String,person_tel:String){
        pRepo.personUpdate(person_id,person_name,person_tel)
    }

}