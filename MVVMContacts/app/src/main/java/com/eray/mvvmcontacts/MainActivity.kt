package com.eray.mvvmcontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.eray.mvvmcontacts.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)







    }


}