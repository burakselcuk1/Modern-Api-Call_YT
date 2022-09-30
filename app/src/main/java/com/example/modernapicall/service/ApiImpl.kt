package com.example.modernapicall.service

import javax.inject.Inject

class ApiImpl @Inject constructor(private val api: Api) {

    suspend fun getMovies()=api.getUpcomingList()


}