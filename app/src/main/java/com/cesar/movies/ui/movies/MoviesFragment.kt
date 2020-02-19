package com.cesar.movies.ui.movies

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.cesar.movies.R
import com.cesar.movies.ui.movies.adapter.MovieAdapter
import com.cesar.movies.ui.movies.model.Movie
import kotlinx.android.synthetic.main.movies_fragment.view.*

class MoviesFragment : Fragment() {

    private lateinit var appView: View
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private var mMovieList: ArrayList<Movie> = ArrayList()

    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        appView = inflater.inflate(R.layout.movies_fragment, container, false)


        setDataToRecyclerView()

        return appView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        // TODO: Use the ViewModel
    }


    private fun setDataToRecyclerView() {

        mockList()

        appView.recycler_view.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        appView.recycler_view.layoutManager = layoutManager

        appView.recycler_view.adapter = MovieAdapter(mMovieList)

    }

    private fun mockList() {

        for (movieIndex in 0..100) {

            var movie = Movie(movieIndex,
                "Movie $movieIndex",
                "Movie Description $movieIndex")


            mMovieList.add(movie)
        }

    }

}
