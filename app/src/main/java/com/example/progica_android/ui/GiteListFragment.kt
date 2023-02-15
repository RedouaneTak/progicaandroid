package com.example.progica_android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.progica_android.R
import com.example.progica_android.databinding.FragmentGiteListBinding

class GiteListFragment : Fragment() {

    private val viewModel : GiteViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGiteListBinding.inflate(inflater)
        // TODO: call the view model method that calls the amphibians api
        viewModel.getGiteList()
        println("liste :" +viewModel.getGiteList())
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = GiteListAdapter(GiteListener { gite ->
            viewModel.onGiteClicked(gite)
            findNavController()
                .navigate(R.id.action_giteListFragment_to_giteDetailFragment)
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}