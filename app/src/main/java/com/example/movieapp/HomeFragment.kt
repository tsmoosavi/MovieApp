package com.example.movieapp

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentHomeBinding

var favoriteMovieList = arrayListOf<Movie>()
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false)
        return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        showStarOfFavortie()
//        changeStarColor()
        var adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter
        adapter.submitList(Film.movieList)


    }

//    private fun showStarOfFavortie() {
////        var buttonList = arrayListOf(binding.star1,binding.star2,binding.star3,
////            binding.star4,binding.star5,binding.star6,
////            binding.star7,binding.star8,binding.star9,
////            binding.star10,binding.star11,binding.star12)   //wher should I put this button list????
//        for (i in 0 until Film.movieList.size){
//            if (favoriteMovieList.contains(Film.movieList[i])){
//                binding.
//                    .setBackgroundResource(R.color.yellow)
//            }else{
//                buttonList[i].setBackgroundResource(R.color.blue)
//            }
//        }
//
//    }
//    fun changeStarColor(){
//       var buttonList = arrayListOf(binding.star1,binding.star2,binding.star3,
//           binding.star4,binding.star5,binding.star6,
//           binding.star7,binding.star8,binding.star9,
//           binding.star10,binding.star11,binding.star12)   //wher should I put this button list????
//       for (i in 0 until buttonList.size){
//            buttonList[i].setOnClickListener{
//                var shPref :SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
//                if (shPref.getString("name",null)!= null){
//                    Film.movieList[i].isFavorite = (!Film.movieList[i].isFavorite)
//                    if (Film.movieList[i].isFavorite){
//                        favoriteMovieList.add(Film.movieList[i])
//                        buttonList[i].setBackgroundResource(R.color.yellow)
//                    }else if (!Film.movieList[i].isFavorite){
//                        favoriteMovieList.remove(Film.movieList[i])
//                        buttonList[i].setBackgroundResource(R.color.blue)
//                    }
//                }else{
//                    Toast.makeText(context, "ابتدا مشخصات خود را وارد کنید.", Toast.LENGTH_SHORT).show()
//                    findNavController().navigate(R.id.action_homeFragment_to_profileFragment    )
//                }
//            }
//       }
//    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.profile ->{
                goToProfileFragment()
                true
            }
            R.id.favorit ->{
                 goToFavoriteFragment()
                 true
            }
            R.id.comingSoon->{
                goToComingSoonFragment()
                true
            }
            else ->return super.onOptionsItemSelected(item)
        }

    }
    private fun goToProfileFragment() {
        var bundle = bundleOf("h" to 1)
        findNavController().navigate(R.id.action_homeFragment_to_profileFragment,bundle)
    }
    private fun goToFavoriteFragment() {
        findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
    }

    private fun goToComingSoonFragment() {
        findNavController().navigate(R.id.action_homeFragment_to_comingSoonFragment)
    }




}