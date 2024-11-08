package com.example.catalogmovie

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<Movie>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getListMovies(): ArrayList<Movie> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataYear = resources.getStringArray(R.array.data_years)
        val dataRate = resources.getStringArray(R.array.data_rate)
        val dataDuration = resources.getStringArray(R.array.data_duration)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataCover = resources.obtainTypedArray(R.array.data_cover)

        val listMovie = ArrayList<Movie>()
        for (i in dataTitle.indices) {
            val movie = Movie(
                dataTitle[i],
                dataYear[i],
                dataRate[i],
                dataDuration[i],
                dataDescription[i],
                dataCover.getResourceId(i, -1)
            )
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun getListMovies(): ArrayList<Movie> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataYear = resources.getStringArray(R.array.data_years)
        val dataRate = resources.getStringArray(R.array.data_rate)
        val dataDuration = resources.getStringArray(R.array.data_duration)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataCover = resources.obtainTypedArray(R.array.data_cover)

        // Return empty list in case of any array size mismatch
        if (dataYear.size != dataTitle.size ||
            dataRate.size != dataTitle.size ||
            dataDuration.size != dataTitle.size ||
            dataDescription.size != dataTitle.size
        ) {
            dataCover.recycle()
            return ArrayList()
        }

//         Initialize the list of movies 1
        val listMovie = ArrayList<Movie>()
        for (i in dataTitle.indices) {
            val movie = Movie(
                dataTitle[i],
                dataYear[i],
                dataRate[i],
                dataDuration[i],
                dataDescription[i],
                dataCover.getResourceId(i, -1)
            )
            listMovie.add(movie)
        }

        // Always recycle the TypedArray
        dataCover.recycle()

        return listMovie
    }
        //2
//        private fun getListMovies(): ArrayList<Movie> {
//            val dataTitle = resources.getStringArray(R.array.data_title) ?: emptyArray()
//            val dataYear = resources.getStringArray(R.array.data_years) ?: emptyArray()
//            val dataRate = resources.getStringArray(R.array.data_rate) ?: emptyArray()
//            val dataDuration = resources.getStringArray(R.array.data_duration) ?: emptyArray()
//            val dataDescription = resources.getStringArray(R.array.data_description) ?: emptyArray()
//            val dataCover = resources.obtainTypedArray(R.array.data_cover)
//
//            if (dataYear.size != dataTitle.size ||
//                dataRate.size != dataTitle.size ||
//                dataDuration.size != dataTitle.size ||
//                dataDescription.size != dataTitle.size) {
//                dataCover.recycle()
//                return ArrayList()
//            }
//
//            val listMovie = ArrayList<Movie>()
//            for (i in dataTitle.indices) {
//                val title = dataTitle[i] ?: "Unknown Title"
//                val year = dataYear[i] ?: "Unknown Year"
//                val rate = dataRate[i] ?: "Unknown Rate"
//                val duration = dataDuration[i] ?: "Unknown Duration"
//                val description = dataDescription[i] ?: "No Description"
//                val coverId = dataCover.getResourceId(i, -1)
//
//                val movie = Movie(title, year, rate, duration, description, coverId)
//                listMovie.add(movie)
//            }
//
//            dataCover.recycle()
//
//            return listMovie
//        }

    private fun showRecyclerList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = ListMovieAdapter(list)
        rvMovies.adapter = listMovieAdapter
    }
}