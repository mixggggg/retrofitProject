package com.example.testovoezadanie.hotel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.testovoezadanie.R
import com.example.testovoezadanie.databinding.FragmentHotelBinding
import com.example.testovoezadanie.utilits.downloadAndSetImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HotelFragment : Fragment(R.layout.fragment_hotel) {

    private lateinit var binding: FragmentHotelBinding
    private lateinit var adapter: AdapterImageHotel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AdapterImageHotel()

        binding.rcVievHotel.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)

        binding.rcVievHotel.adapter = adapter

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

       // val image = binding.imageOtel

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val hotelApi = retrofit.create(HotelApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {

            val hotel = hotelApi.hotelInfo()

            val images = hotelApi.hotelList()


            binding.nameOtel.text = hotel.name
            binding.nameOtel1.text = hotel.adress
            binding.nameOtel2.text = hotel.minimal_price.toString()
            binding.nameOtel3.text = hotel.price_for_it
            binding.nameOtel4.text = hotel.rating.toString()
            binding.nameOtel5.text = hotel.rating_name
            binding.hotelDescription.text = hotel.about_the_hotel.description

            adapter.submitList(images.image_urls)

        }

        onClick()
    }


    private fun onClick() {
        val navigation = findNavController()

        binding.buttonHotel.setOnClickListener { navigation.navigate(R.id.action_hotelFragment_to_infoListFragment) }

    }
}

