package com.example.testinstaleap.retrofit

import com.example.testinstaleap.model.Results
import com.example.testinstaleap.utils.GET_RESULTS
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(GET_RESULTS)
    fun getResults(): Call<Results>
}