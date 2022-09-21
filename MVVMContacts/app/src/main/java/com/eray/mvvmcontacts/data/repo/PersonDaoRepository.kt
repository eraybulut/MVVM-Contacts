package com.eray.mvvmcontacts.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.eray.mvvmcontacts.R
import com.eray.mvvmcontacts.data.entity.Person
import com.eray.mvvmcontacts.room.PersonDao
import com.eray.mvvmcontacts.util.navigate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PersonDaoRepository(var pDao:PersonDao) {
    var personList:MutableLiveData<List<Person>>

    init {
        personList= MutableLiveData()
    }

    fun getPerson():MutableLiveData<List<Person>>{
        return personList
    }

    fun personAdd(personName:String,personTel:String){
        var job= CoroutineScope(Dispatchers.Main).launch {
            var newPerson=Person(0,personName,personTel)

            pDao.addPerson(newPerson)

        }
    }

    fun personUpdate(person_id:Int,person_name:String,person_tel:String){
       var job= CoroutineScope(Dispatchers.Main).launch {
           var updatePerson=Person(person_id,person_name,person_tel)
           pDao.updatePerson(updatePerson)
       }
    }

    fun personSearch(searchText:String){
        var job= CoroutineScope(Dispatchers.Main).launch {
            personList.value=pDao.personSearch(searchText)
        }

    }

    fun personDelete(person_id: Int){
       val job= CoroutineScope(Dispatchers.Main).launch {
           var deletePerson=Person(person_id,"0","0")
           pDao.deletePerson(deletePerson)
           personAll()
       }
    }

    fun personAll(){
        val job= CoroutineScope(Dispatchers.Main).launch {
            personList.value=pDao.allPerson()
        }
    }
}