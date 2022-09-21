package com.eray.mvvmcontacts.room

import androidx.room.*
import com.eray.mvvmcontacts.data.entity.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM contacts")
    suspend fun allPerson():List<Person>


    @Query("SELECT * FROM contacts WHERE person_name LIKE '%'||:searchText ||'%'")
    suspend fun personSearch(searchText:String):List<Person>


    @Insert
    suspend fun addPerson(person: Person)

    @Update
    suspend fun updatePerson(person: Person)

    @Delete
    suspend fun deletePerson(person: Person)


}