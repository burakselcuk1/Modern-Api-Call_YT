package com.example.modernapicall.service

import com.example.modernapicall.Utils.Constans.Companion.API_KEY
import com.example.shortmovieapp.model.Result
import com.example.shortmovieapp.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("3/movie/upcoming?")
    suspend fun getUpcomingList(
        @Query("api_key")
        apiKey:String=API_KEY
    ): Movie

}