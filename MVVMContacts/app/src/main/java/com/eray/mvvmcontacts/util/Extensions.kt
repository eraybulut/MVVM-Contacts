package com.eray.mvvmcontacts.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.eray.mvvmcontacts.R


fun Navigation.navigate(view:View,id:Int){
    findNavController(view).navigate(id)
}
fun Navigation.navigate(view: View,navDirections: NavDirections){
    findNavController(view).navigate(navDirections)
}
