package com.example.movieapp

object Film {
    var movie1 = Movie(R.drawable.fastfive,"fast and furious 5")
    var movie2 = Movie(R.drawable.fastsix,"fast and furious 6")
    var movie3 = Movie(R.drawable.fastseven,"fast and furious 7")
    var movie4 = Movie(R.drawable.fasteight,"fast and furious 8")
    var movie5 = Movie(R.drawable.fastnine,"fast and furious 9")
    var movie6 = Movie(R.drawable.mithree,"mission Impossible 3")
    var movie7 = Movie(R.drawable.mifour,"mission Impossible 4")
    var movie8 = Movie(R.drawable.mifive,"mission Impossible 5")
    var movie9 = Movie(R.drawable.freeguy,"free guy")
    var movie10 = Movie(R.drawable.venomone,"venom")
    var movie11 = Movie(R.drawable.venomtow,"venom 2")
    var movie12 = Movie(R.drawable.sing,"sing")
//    var movie13 = Movie(R.drawable.inside,"inside Out")
    var movieList = arrayListOf(movie1, movie2,movie3, movie4,movie5, movie6,movie7, movie8,movie9, movie10,movie11, movie12)


}

class Movie(var imageId:Int, var nameId: String){
    var isFavorite = false
}