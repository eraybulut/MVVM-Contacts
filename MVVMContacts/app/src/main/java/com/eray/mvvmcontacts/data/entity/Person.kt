package com.eray.mvvmcontacts.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "contacts")
data class Person(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "person_id") @NotNull var person_id:Int,
    @ColumnInfo(name = "person_name") @NotNull var personName:String,
    @ColumnInfo(name = "person_number")@NotNull var personTel:String
    ):java.io.Serializable