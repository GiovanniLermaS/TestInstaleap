package com.example.testinstaleap.view.main

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testinstaleap.databinding.ActivityMainBinding
import com.example.testinstaleap.model.MoviesSeries
import com.example.testinstaleap.utils.MOVIE
import com.example.testinstaleap.utils.SERIES
import com.example.testinstaleap.view.main.adapter.MoviesAdapter
import com.example.testinstaleap.view.main.interfaces.ClickMovieSeries
import com.example.testinstaleap.viewmodel.MainActivityViewModel
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ClickMovieSeries, TabLayout.OnTabSelectedListener {

    private val homeActivityViewModel by viewModels<MainActivityViewModel>()

    private var binding: ActivityMainBinding? = null

    private val progress by lazy { ProgressDialog(this) }

    private var moviesAdapter: MoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        progress.show()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = "All - Movies and Series"
        addTabsLayout()
        addObservers()
        homeActivityViewModel.getResults()
    }

    override fun onMovieSelected(moviesSeries: MoviesSeries) {}

    override fun onTabReselected(tab: TabLayout.Tab?) {}

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when (tab?.position) {
            0 -> moviesAdapter?.updateResults(null, this)
            1 -> moviesAdapter?.updateResults(MOVIE, this)
            else -> moviesAdapter?.updateResults(SERIES, this)
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {}

    private fun addTabsLayout() {
        val tabLayout = binding?.tabLayout
        tabLayout?.addTab(tabLayout.newTab().setText("All"))
        tabLayout?.addTab(tabLayout.newTab().setText("Movies"))
        tabLayout?.addTab(tabLayout.newTab().setText("Series"))
        tabLayout?.addOnTabSelectedListener(this)
    }

    private fun addObservers() {
        homeActivityViewModel.results.observe(this) {
            moviesAdapter = MoviesAdapter(it, this, supportActionBar)
            binding?.rvMoviesSeries?.adapter = moviesAdapter
            progress.dismiss()
        }
        homeActivityViewModel.error.observe(this) {
            progress.dismiss()
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}