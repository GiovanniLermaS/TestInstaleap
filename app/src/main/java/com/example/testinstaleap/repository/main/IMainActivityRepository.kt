package com.example.testinstaleap.repository.main

import com.example.testinstaleap.model.Results

interface IMainActivityRepository {
    fun getResults(
        response: (Results) -> Unit,
        error: (String?) -> Unit
    )
}