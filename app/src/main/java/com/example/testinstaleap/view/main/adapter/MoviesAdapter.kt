package com.example.testinstaleap.view.main.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.testinstaleap.R
import com.example.testinstaleap.databinding.ViewMoviesSeriesBinding
import com.example.testinstaleap.model.MoviesSeries
import com.example.testinstaleap.model.Results
import com.example.testinstaleap.utils.MOVIE
import com.example.testinstaleap.utils.SERIES
import com.example.testinstaleap.view.main.interfaces.ClickMovieSeries

class MoviesAdapter(
    private val results: Results,
    private val clickMovieSeries: ClickMovieSeries,
    private val supportActionBar: ActionBar?
) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var temporalResults = ArrayList<MoviesSeries>()

    init {
        temporalResults.addAll(results.moviesSeries)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ViewMoviesSeriesBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_movies_series, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val movie = results.moviesSeries[position]
        holder.binding.name.text = movie.name
        if (movie.type == MOVIE)
            holder.binding.type.setImageDrawable(setImage(context, R.drawable.movie))
        else holder.binding.type.setImageDrawable(setImage(context, R.drawable.serie))
        holder.itemView.setOnClickListener { clickMovieSeries.onMovieSelected(movie) }
    }

    override fun getItemCount() = results.moviesSeries.size

    private fun setImage(context: Context, drawable: Int): Drawable? {
        return ResourcesCompat.getDrawable(
            context.resources,
            drawable,
            null
        )
    }

    fun updateResults(type: String?, context: Context) {
        results.moviesSeries.clear()
        results.moviesSeries.addAll(
            when (type) {
                MOVIE -> {
                    supportActionBar?.title = "Movies"
                    temporalResults.filter { it.type == MOVIE }
                }
                SERIES -> {
                    supportActionBar?.title = "Series"
                    temporalResults.filter { it.type == SERIES }
                }
                else -> {
                    supportActionBar?.title = "All - Movies and Series"
                    temporalResults
                }
            }
        )
        notifyDataSetChanged()
    }
}