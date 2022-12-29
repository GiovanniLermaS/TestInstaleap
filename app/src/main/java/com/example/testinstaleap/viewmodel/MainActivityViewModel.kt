package com.example.testinstaleap.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testinstaleap.model.Results
import com.example.testinstaleap.repository.main.IMainActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val mainActivityRepository: IMainActivityRepository) :
    ViewModel() {

    private val _results = MutableLiveData<Results>()
    val results: LiveData<Results> = _results

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getResults() {
        mainActivityRepository.getResults({
            _results.postValue(it)
        }, {
            _error.postValue(it)
        })
    }
}