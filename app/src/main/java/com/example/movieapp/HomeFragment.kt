package com.example.movieapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentHomeBinding


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
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.profile ->{
                goToProfileFragmint()
                true
            }
            R.id.favorit ->{
                 goToFavoriteFragmint()
                 true
            }
            R.id.comingSoon->{
                goToComingSoonFragmint()
                true
            }
            else ->return super.onOptionsItemSelected(item)
        }

    }
    private fun goToProfileFragmint() {
        findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
    }
    private fun goToFavoriteFragmint() {
        findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
    }

    private fun goToComingSoonFragmint() {
        findNavController().navigate(R.id.action_homeFragment_to_comingSoonFragment)
    }




}