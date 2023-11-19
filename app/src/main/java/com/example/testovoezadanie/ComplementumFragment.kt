package com.example.testovoezadanie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testovoezadanie.databinding.FragmentComplementumBinding

class ComplementumFragment : Fragment(R.layout.fragment_complementum) {

    private lateinit var binding: FragmentComplementumBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComplementumBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
        val navigation = findNavController()

        binding.backButton.setOnClickListener { navigation.navigate(R.id.action_complementumFragment_to_infoFragment) }
        binding.buttonGoHotel.setOnClickListener { navigation.navigate(R.id.action_complementumFragment_to_hotelFragment) }
    }
}