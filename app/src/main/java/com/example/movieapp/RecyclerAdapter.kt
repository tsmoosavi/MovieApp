package com.example.movieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemrecyclerBinding



typealias clickHandler = (Movie) ->Unit
class RecyclerAdapter(): ListAdapter<Movie, RecyclerAdapter.ItemHolder>(MovieDiffCallback) {
    var favoriteMovieList = arrayListOf<Movie>()
    class ItemHolder(val binding: ItemrecyclerBinding):RecyclerView.ViewHolder(binding.root)

    object MovieDiffCallback: DiffUtil.ItemCallback<Movie>(){

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }


        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.nameId == newItem.nameId
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding: ItemrecyclerBinding  = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.itemrecycler,
            parent,false
        )
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemrecycler, parent, false)

        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
       holder.binding.film = getItem(position)
        holder.binding.star.setOnClickListener {
            if (Film.movieList[position].isFavorite){
                Film.movieList[position].isFavorite = !Film.movieList[position].isFavorite
                favoriteMovieList.add(Film.movieList[position])
                holder.binding.star.setBackgroundResource(R.color.yellow)
            }
            else if (!Film.movieList[position].isFavorite){
                favoriteMovieList.remove(Film.movieList[position])
                holder.binding.star.setBackgroundResource(R.color.blue)
            }

//        clickMovie.invoke(getItem(position))
        }
    }
}