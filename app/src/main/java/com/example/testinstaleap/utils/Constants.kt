package com.example.testinstaleap.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

const val BASE_URL = "https://run.mocky.io/v3/"
const val GET_RESULTS = "72f66f33-9186-4b20-a9a6-2c65661bc9cf"
const val MOVIE = "MOVIE"
const val SERIES = "SERIES"

fun hasNetwork(context: Context): Boolean? {
    var isConnected: Boolean? = false
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}