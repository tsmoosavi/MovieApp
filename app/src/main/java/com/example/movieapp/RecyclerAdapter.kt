package com.example.movieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.RecyclerItemsBinding

class RecyclerAdapter: ListAdapter<Movie, RecyclerAdapter.ItemHolder>(MovieDiffCallback) {
    class ItemHolder(val binding: RecyclerItemsBinding):RecyclerView.ViewHolder(binding.root)

    object MovieDiffCallback: DiffUtil.ItemCallback<Movie>(){

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }


        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.nameId == newItem.nameId
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding: RecyclerItemsBinding  = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_items,
            parent,false
        )
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_items, parent, false)

        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
       holder.binding.film = getItem(position)
    }
}