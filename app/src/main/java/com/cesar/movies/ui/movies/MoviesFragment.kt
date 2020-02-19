package com.cesar.movies.ui.movies

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.cesar.movies.R
import com.cesar.movies.ui.movies.adapter.MovieAdapter
import com.cesar.movies.ui.movies.model.Movie
import com.cesar.movies.utils.ClickListener
import com.cesar.movies.utils.RecyclerTouchListener
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
        click()

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

    /**
     * This method is responsible for performing the click action on the card.
     */
    private fun click() {

        appView.recycler_view.addOnItemTouchListener(
            RecyclerTouchListener.RecyclerTouchListener(
                activity!!.applicationContext,
                object : ClickListener {
                    override fun onClick(position: Int) {

                        val bundle = bundleOf("movie" to mMovieList[position].id)
                        Navigation.findNavController(appView)
                            .navigate(R.id.action_moviesFragment_to_detailsFragment, bundle)

                    }

                })
        )

    }

}
