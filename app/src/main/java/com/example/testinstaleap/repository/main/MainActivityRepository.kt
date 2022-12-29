package com.example.testinstaleap.repository.main

import com.example.testinstaleap.model.Results
import com.example.testinstaleap.retrofit.ApiInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@ActivityRetainedScoped
class MainActivityRepository(private val apiInterface: ApiInterface) : IMainActivityRepository {

    override fun getResults(response: (Results) -> Unit, error: (String?) -> Unit) {
        val call = apiInterface.getResults()
        call.enqueue(object : Callback<Results> {
            override fun onResponse(
                call: Call<Results>,
                response: Response<Results>
            ) {
                response.body()?.let { response(it) }
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {
                t.message?.let { error(it) }
            }

        })
    }
}