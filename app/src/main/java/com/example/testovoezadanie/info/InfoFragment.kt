package com.example.testovoezadanie.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testovoezadanie.R
import com.example.testovoezadanie.databinding.FragmentInfoBinding


class InfoFragment : Fragment(R.layout.fragment_info) {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {

        val navigation = findNavController()

        binding.backButton.setOnClickListener { navigation.navigate(R.id.action_infoFragment_to_infoListFragment) }
        binding.buttonGoComplementum.setOnClickListener { navigation.navigate(R.id.action_infoFragment_to_complementumFragment) }
    }
}