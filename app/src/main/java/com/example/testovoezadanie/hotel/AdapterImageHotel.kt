package com.example.testovoezadanie.hotel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testovoezadanie.R
import com.example.testovoezadanie.databinding.ItemHotelImageBinding
import com.example.testovoezadanie.utilits.downloadAndSetImage

class AdapterImageHotel(): ListAdapter<Images, AdapterImageHotel.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ItemHotelImageBinding.bind(view)

        fun bind(imagehotel: Images)= with(binding){

            imagehotel.image_urls.toArray()

           // imageHotelMain.downloadAndSetImage(imagehotel.image_urls.toArray().toString())
        }
    }

   // private var additionalList = listOf<HotelModel>()

    class Comparator: DiffUtil.ItemCallback<Images>(){
        override fun areItemsTheSame(oldItem: Images, newItem: Images): Boolean {
            return oldItem.image_urls == newItem.image_urls
        }

        override fun areContentsTheSame(oldItem: Images, newItem: Images): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hotel_image, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}