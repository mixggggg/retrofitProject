package com.example.testovoezadanie.hotel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.testovoezadanie.R
import com.example.testovoezadanie.utilits.downloadAndSetImage

class AdapterHotel(private val Directorylist:ArrayList<HotelModel>): RecyclerView.Adapter<AdapterHotel.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_hotel_image,
            parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return Directorylist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = Directorylist[position]
        holder.im.downloadAndSetImage(currentItem.image_urls.toString())


    }

    class ViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem) {
        val im = viewItem.findViewById<ImageView>(R.id.image_hotel_main)
    }
}