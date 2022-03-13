package com.example.movieapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.movieapp.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment() {
    var imageList = arrayListOf<ImageView>()
    var movieNameList = arrayListOf<TextView>()
    var i = 0
    lateinit var binding: FragmentFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentFavoriteBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var shPref : SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
        listOfImageViews()
        listOfTextviews()
        if (shPref.getString("name",null)!= null){

        }
    }
    fun listOfImageViews(){
        imageList.add(binding.image1)
        imageList.add(binding.image2)
        imageList.add(binding.image3)
        imageList.add(binding.image4)
        imageList.add(binding.image5)
        imageList.add(binding.image6)
        imageList.add(binding.image7)
        imageList.add(binding.image8)
        imageList.add(binding.image9)
        imageList.add(binding.image10)
        imageList.add(binding.image11)
        imageList.add(binding.image12)
    }
    fun listOfTextviews(){
        movieNameList.add(binding.movieName1)
        movieNameList.add(binding.movieName2)
        movieNameList.add(binding.movieName3)
        movieNameList.add(binding.movieName4)
        movieNameList.add(binding.movieName5)
        movieNameList.add(binding.movieName6)
        movieNameList.add(binding.movieName7)
        movieNameList.add(binding.movieName8)
        movieNameList.add(binding.movieName9)
        movieNameList.add(binding.movieName10)
        movieNameList.add(binding.movieName11)
        movieNameList.add(binding.movieName12)
    }
}