package com.example.testinstaleap.model

import com.google.gson.annotations.SerializedName

class MovieSeries(
    @SerializedName("name") var name: String?,
    @SerializedName("type") var type: String?
)