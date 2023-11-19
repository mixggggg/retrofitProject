package com.example.testovoezadanie.hotel

data class HotelModel(
    var id: Int,
    var name: String,
    var adress: String,
    var minimal_price: Int,
    var price_for_it: String,
    var rating: Int,
    var rating_name: String,
    var image_urls: List<String>,
    var about_the_hotel: HotelAboutModel
)

data class HotelAboutModel(
    var description: String,
    var peculiarities: List<String>
)


