package com.eray.mvvmcontacts.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.eray.mvvmcontacts.R
import com.eray.mvvmcontacts.ui.adapter.PersonAdapter
import com.eray.mvvmcontacts.data.entity.Person
import com.eray.mvvmcontacts.databinding.FragmentHomeBinding
import com.eray.mvvmcontacts.ui.viewModel.HomeViewModel
import com.eray.mvvmcontacts.util.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var personArrayList:ArrayList<Person>
    private lateinit var personAdapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewNodel: HomeViewModel by viewModels()
        viewModel=tempViewNodel

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        binding.homeFragment=this


        binding.toolbarHome="Contacts"


        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHomeFragment)

        binding.recyclerView.setHasFixedSize(true)

        viewModel.personList.observe( viewLifecycleOwner){
            personAdapter= PersonAdapter(requireContext(),it,viewModel)
            binding.personAdapter=personAdapter
        }








        //Toolbar Menu
        requireActivity().addMenuProvider(object :MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                //Search bar
                val item=menu.findItem(R.id.action_search)
                var searchView=item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)



        return binding.root
    }

    fun fabAddButton(view: View){
        Navigation.navigate(view,R.id.goToAddPerson)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }


    override fun onResume() {
        super.onResume()
        viewModel.allPerson()
    }
}