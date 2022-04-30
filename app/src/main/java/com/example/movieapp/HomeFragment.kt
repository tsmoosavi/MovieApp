package com.example.movieapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.databinding.FragmentHomeBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.common.collect.ImmutableList

var favoriteMovieList = arrayListOf<Movie>()
class HomeFragment : Fragment() , Player.Listener{
    lateinit var binding: FragmentHomeBinding
    private lateinit var player: ExoPlayer
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
        setupPlayer()
        addMP4Files()
        addMP3()

        var linearShow = true
        binding.changeView.setOnClickListener {
            linearShow = !linearShow
            if (linearShow){
                binding.recyclerView.layoutManager =LinearLayoutManager(context)
            }else if(!linearShow){
                binding.recyclerView.layoutManager = GridLayoutManager(context,3)
            }
        }


        var adapter = RecyclerAdapter{
            button, film ->onMovieClick (button, film)
        }
        binding.recyclerView.adapter = adapter
        adapter.submitList(Film.movieList)
    }

    private fun addMP3() {
        val mediaItem = MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/play.mp3")
        player.setMediaItem(mediaItem)
        player.setMediaItem(mediaItem)
        player.prepare()
    }

    /**
     * Called when the Fragment is no longer started.  This is generally
     * tied to [Activity.onStop] of the containing
     * Activity's lifecycle.
     */
    override fun onStop() {
        super.onStop()
        player.release()
    }
    override fun onResume() {
            super.onResume()
            setupPlayer()
            addMP3()
            addMP4Files()
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("player", "onSaveInstanceState: " + player.currentPosition)
    }


    private fun addMP4Files() {
        val mediaItem = MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4")
        val newItems: List<MediaItem> = ImmutableList.of(
            mediaItem
        )
        player.addMediaItems(newItems)
        player.prepare()
    }

    private fun setupPlayer() {
        player = ExoPlayer.Builder(requireActivity()).build()
        binding.exoPlayer.player = player
        player.addListener(this)
    }


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

    fun onMovieClick(button: ImageButton, film:Movie){
        if (film.isFavorite){
            button.setBackgroundResource(R.color.yellow)
        }
        else if (!film.isFavorite){
            button.setBackgroundResource(R.color.blue)
        }

            button.setOnClickListener{
                var shPref : SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
                if (shPref.getString("name",null)!= null){
                    film.isFavorite = !film.isFavorite
                    if (film.isFavorite){
                        Toast.makeText(activity, "Added to Favorite", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(activity, "Remove from Favorite", Toast.LENGTH_SHORT).show()
                    }
                    if (film.isFavorite){
                        favoriteMovieList.add(film)
                        button.setBackgroundResource(R.color.yellow)
                    }
                    else if (!film.isFavorite){
                        favoriteMovieList.remove(film)
                        button.setBackgroundResource(R.color.blue)
                    }
                }else{
                    Toast.makeText(context, "ابتدا مشخصات خود را وارد کنید.", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_homeFragment_to_profileFragment    )
                }

            }
    }
}