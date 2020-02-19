package com.cesar.movies.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cesar.movies.R
import com.cesar.movies.ui.movies.model.Movie

class MovieAdapter(movieList: ArrayList<Movie>): RecyclerView.Adapter<MovieViewHolder>() {

    private var mMovieList: ArrayList<Movie> = movieList

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_movies, viewGroup, false)

        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(helpViewHolder: MovieViewHolder, position: Int) {
        val movie = mMovieList[position]
        helpViewHolder.title.text = movie.title
        helpViewHolder.subtitle.text = movie.description
    }

    override fun getItemCount(): Int {
        return mMovieList.size
    }
}