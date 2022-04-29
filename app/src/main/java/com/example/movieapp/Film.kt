package com.example.movieapp

object Film {
    var movie1 = Movie(R.drawable.fastfive,R.string.fast5,R.id.star1)
    var movie2 = Movie(R.drawable.fastsix,R.string.fast6,R.id.star2)
    var movie3 = Movie(R.drawable.fastseven,R.string.fast7,R.id.star3)
    var movie4 = Movie(R.drawable.fasteight,R.string.fast8,R.id.star4)
    var movie5 = Movie(R.drawable.fastnine,R.string.fast9,R.id.star5)
    var movie6 = Movie(R.drawable.mithree,R.string.missionImpossible3,R.id.star6)
    var movie7 = Movie(R.drawable.mifour,R.string.missionImpossible4,R.id.star7)
    var movie8 = Movie(R.drawable.mifive,R.string.missionImpossible5,R.id.star8)
    var movie9 = Movie(R.drawable.freeguy,R.string.freeGuy,R.id.star9)
    var movie10 = Movie(R.drawable.venomone,R.string.venom,R.id.star10)
    var movie11 = Movie(R.drawable.venomtow,R.string.venom2,R.id.star11)
    var movie12 = Movie(R.drawable.sing,R.string.sing,R.id.star12)
    var movie13 = Movie(R.drawable.inside,R.string.insideOut,R.id.star13)
    var movieList = arrayListOf(movie1, movie2,movie3, movie4,movie5, movie6,movie7, movie8,movie9, movie10,movie11, movie12)


}

class Movie(var imageId:Int, var nameId: Int, var starId: Int){
    var isFavorite = false
}