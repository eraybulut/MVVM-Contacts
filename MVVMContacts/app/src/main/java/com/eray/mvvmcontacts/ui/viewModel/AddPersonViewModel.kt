package com.eray.mvvmcontacts.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.eray.mvvmcontacts.data.repo.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddPersonViewModel @Inject constructor(var pRepo:PersonDaoRepository) : ViewModel() {

    fun save(personName:String,personTel:String){
       pRepo.personAdd(personName,personTel)
    }
}