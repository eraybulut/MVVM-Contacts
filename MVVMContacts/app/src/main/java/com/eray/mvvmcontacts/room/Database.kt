package com.eray.mvvmcontacts.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eray.mvvmcontacts.data.entity.Person

@Database(entities = [Person::class], version = 1)
abstract class Database :RoomDatabase(){

    abstract fun getPersonDao():PersonDao




}