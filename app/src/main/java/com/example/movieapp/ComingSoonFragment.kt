package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.movieapp.databinding.FragmentComingSoonBinding

class ComingSoonFragment : Fragment() {
    lateinit var binding: FragmentComingSoonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComingSoonBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding.share1.setOnClickListener{
                Toast.makeText(context, R.string.avatar2, Toast.LENGTH_SHORT).show()
                firstMovieShareInfo()
            }
        binding.share2.setOnClickListener{
            Toast.makeText(context, R.string.matrix4, Toast.LENGTH_SHORT).show()
            secondMovieShareInfo()
        }
        binding.share3.setOnClickListener{
            Toast.makeText(context, R.string.singTow, Toast.LENGTH_SHORT).show()
            thirdMovieShareInfo()
        }
    }



    private fun firstMovieShareInfo() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,getString(R.string.avatar2))
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    private fun secondMovieShareInfo() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, getString(R.string.matrix4))
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
    private fun thirdMovieShareInfo() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, getString(R.string.singTow))
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }





}