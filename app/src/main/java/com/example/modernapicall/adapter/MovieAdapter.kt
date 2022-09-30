package com.example.modernapicall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.modernapicall.R
import com.example.modernapicall.Utils.Constans.Companion.POSTER_MAIN_URL
import com.example.modernapicall.databinding.SingleMovieItemBinding
import com.example.shortmovieapp.model.Movie
import kotlinx.android.synthetic.main.single_movie_item.view.*


class MovieAdapter(private val dataSet: Movie) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private lateinit var binding: SingleMovieItemBinding

    class ViewHolder(view: SingleMovieItemBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        binding = SingleMovieItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {


        binding.movieInformation = dataSet.results[position]

        val url = POSTER_MAIN_URL + dataSet.results[position].poster_path
        viewHolder.itemView.apply {
            Glide.with(this).load(url).into(viewHolder.itemView.movieImage)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.results.size

}
