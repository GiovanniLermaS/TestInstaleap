package com.example.testinstaleap.model

import com.google.gson.annotations.SerializedName

class Results {

    @SerializedName("results")
    val moviesSeries = ArrayList<MoviesSeries>()
}