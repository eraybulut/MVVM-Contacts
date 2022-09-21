package com.eray.mvvmcontacts.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.eray.mvvmcontacts.R
import com.eray.mvvmcontacts.data.entity.Person
import com.eray.mvvmcontacts.databinding.CardViewBinding
import com.eray.mvvmcontacts.ui.fragment.HomeFragmentDirections
import com.eray.mvvmcontacts.ui.viewModel.HomeViewModel
import com.eray.mvvmcontacts.util.navigate
import com.google.android.material.snackbar.Snackbar

class PersonAdapter(var mContext: Context
                    ,var incomingPersonList:List<Person>,var viewModel: HomeViewModel
):RecyclerView.Adapter<PersonAdapter.CardViewHolder>() {


    inner class CardViewHolder(view:CardViewBinding):RecyclerView.ViewHolder(view.root){

        var view:CardViewBinding
        init {
            this.view=view
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        var layoutInflater=LayoutInflater.from(mContext)
        val view:CardViewBinding=DataBindingUtil.inflate(layoutInflater,R.layout.card_view,parent,false)
        return CardViewHolder(view)

    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        var persons=incomingPersonList[position]


        holder.view.personObject=persons



        holder.view.rvCardView.setOnClickListener(){
            val intent=HomeFragmentDirections.goToDetailPerson(persons)
            Navigation.navigate(it,intent)
        }


        holder.view.imageViewDeletePerson.setOnClickListener(){
            Snackbar.make(it,"Delete ${persons.personName} ?",Snackbar.LENGTH_SHORT).setAction("Yes"){
                viewModel.delete(persons.person_id)
            }.show()
        }

    }
    override fun getItemCount(): Int {
       return incomingPersonList.size
    }

}