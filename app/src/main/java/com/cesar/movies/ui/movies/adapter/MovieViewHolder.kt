package com.cesar.movies.ui.movies.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_movies.view.*

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var title: TextView = itemView.textViewTitle
    var subtitle: TextView = itemView.textViewSubTitle
}

