package com.eray.mvvmcontacts.di

import android.content.Context
import androidx.room.Room
import com.eray.mvvmcontacts.data.repo.PersonDaoRepository
import com.eray.mvvmcontacts.room.Database
import com.eray.mvvmcontacts.room.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providePersonDaoRepository(pDao:PersonDao): PersonDaoRepository{
        return PersonDaoRepository(pDao)
    }

    @Provides
    @Singleton
    fun providePersonDao(@ApplicationContext context: Context): PersonDao{

        //Database copy from assets
        val db=Room.databaseBuilder(context,Database::class.java,"contacts.sqlite")
            .createFromAsset("contacts.sqlite").build()

        return db.getPersonDao()
    }

}