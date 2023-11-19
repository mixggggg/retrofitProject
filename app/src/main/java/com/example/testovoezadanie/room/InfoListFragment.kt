package com.example.testovoezadanie.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testovoezadanie.R
import com.example.testovoezadanie.databinding.FragmentInfoListBinding

class InfoListFragment : Fragment(R.layout.fragment_info_list) {

    private lateinit var binding: FragmentInfoListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
         val navigation = findNavController()

        binding.backButton.setOnClickListener{ navigation.navigate(R.id.action_infoListFragment_to_hotelFragment)}
    }
}