package com.example.movieapp

object Film {
    var movie1 = Movie(R.drawable.fastfive,R.string.fast5,R.id.star1)

}

class Movie(var imageId:Int, var nameId: Int, var starId: Int)