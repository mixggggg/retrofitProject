package com.example.testovoezadanie.hotel

import retrofit2.http.GET

interface HotelApi {

    @GET("v3/d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun hotelInfo(): HotelModel


}