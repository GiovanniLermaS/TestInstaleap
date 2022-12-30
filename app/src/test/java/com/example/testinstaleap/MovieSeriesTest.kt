package com.example.testinstaleap

import com.example.testinstaleap.model.MovieSeries
import com.example.testinstaleap.utils.MOVIE
import com.example.testinstaleap.utils.SERIES
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class MovieSeriesTest {

    private val moviesSeries =
        arrayListOf(
            MovieSeries("Parasite", "MOVIE"),
            MovieSeries("Captain Marvel", "MOVIE"),
            MovieSeries("The Big Bang Theory", "SERIES"),
            MovieSeries("How I Met Your Mother", "SERIES"),
            MovieSeries(null, "SERIES"),
            MovieSeries("The Mandalorian", null)
        )

    @Test
    fun `if name is correct`() {
        assertEquals("The Big Bang Theory", moviesSeries[2].name)
        assertEquals(null, moviesSeries[4].name)
    }

    @Test
    fun `if type is correct`() {
        assertEquals(MOVIE, moviesSeries[0].type)
        assertEquals(null, moviesSeries[5].type)
    }

    @Test
    fun `if all types serie are correct`() {
        val series = moviesSeries.filter { it.type == SERIES }
        for (serie in series)
            assertTrue(serie.type == SERIES)
    }

    @Test
    fun `if all types movie are correct`() {
        val series = moviesSeries.filter { it.type == MOVIE }
        for (serie in series)
            assertTrue(serie.type == MOVIE)
    }

    @Test
    fun `if list of movies or series  aren't empty`() {
        assertTrue(moviesSeries.size > 0)
    }
}