package com.example.modernapicall.repository

import com.example.modernapicall.service.Api
import com.example.modernapicall.service.ApiImpl
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieApiımple: ApiImpl) {

    suspend fun getMovies()=movieApiımple.getMovies()

}