package com.eray.mvvmcontacts.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eray.mvvmcontacts.data.entity.Person
import com.eray.mvvmcontacts.data.repo.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var pRepo:PersonDaoRepository):ViewModel() {


    var personList=MutableLiveData<List<Person>>()

    init {
        allPerson()
        personList=pRepo.getPerson()
    }

    fun search(searchText:String){
        pRepo.personSearch(searchText)
    }

    fun delete(person_id:Int){
        pRepo.personDelete(person_id)
    }

    fun allPerson(){
        pRepo.personAll()

    }
}