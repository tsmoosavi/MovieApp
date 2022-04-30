package com.example.movieapp

object Film {
    var movie1 = Movie(R.drawable.fastone,"fast and furious 1")
    var movie2 = Movie(R.drawable.fasttow,"fast and furious 2")
    var movie3 = Movie(R.drawable.fastthree,"fast and furious 3")
    var movie4 = Movie(R.drawable.fastfour,"fast and furious 4")
    var movie5 = Movie(R.drawable.fastfive,"fast and furious 5")
    var movie6 = Movie(R.drawable.fastsix,"fast and furious 6")
    var movie7 = Movie(R.drawable.fastseven,"fast and furious 7")
    var movie8 = Movie(R.drawable.fasteight,"fast and furious 8")
    var movie9 = Movie(R.drawable.fastnine,"fast and furious 9")
    var movie10 = Movie(R.drawable.mione,"mission Impossible 1")
    var movie11 = Movie(R.drawable.mitow,"mission Impossible 2")
    var movie12 = Movie(R.drawable.mithree,"mission Impossible 3")
    var movie13 = Movie(R.drawable.mifour,"mission Impossible 4")
    var movie14 = Movie(R.drawable.mifive,"mission Impossible 5")
    var movie15 = Movie(R.drawable.misix,"mission Impossible 6")
    var movie16 = Movie(R.drawable.freeguy,"free guy")
    var movie17 = Movie(R.drawable.six,"6 Underground")
    var movie18 = Movie(R.drawable.dead,"deadpool")
    var movie19 = Movie(R.drawable.deadtow,"deadpool 2")
    var movie20 = Movie(R.drawable.venomone,"venom")
    var movie21 = Movie(R.drawable.venomtow,"venom 2")
    var movie22 = Movie(R.drawable.sing,"sing")
    var movie23 = Movie(R.drawable.inside,"inside Out")
    var movie24 = Movie(R.drawable.soul,"soul")
    var movie25 = Movie(R.drawable.queen,"شاهزاده روم")
    var movie26 =  Movie(R.drawable.location,"موقعیت مهدی")
    var movie27 = Movie(R.drawable.rooz,"روز صفر")
    var movie28 = Movie(R.drawable.majara,"ماجرای نیمروز")
    var movie29 = Movie(R.drawable.body,"بادیگارد")
    var movie30 = Movie(R.drawable.molk,"ملک سلیمان نبی")

    var movieList = arrayListOf(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11, movie12, movie13, movie14, movie15,
                                 movie16, movie17, movie18, movie19, movie20, movie21, movie22, movie23, movie24, movie25, movie26, movie27, movie28, movie29, movie30)


}

class Movie(var imageId:Int, var nameId: String){
    var isFavorite = false
}