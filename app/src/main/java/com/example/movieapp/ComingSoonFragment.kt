package com.example.movieapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_coming_soon,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var shPref : SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
            binding.share1.setOnClickListener{
                if (shPref.getString("name",null)!= null){
                    Toast.makeText(context, R.string.avatar2, Toast.LENGTH_SHORT).show()
                    firstMovieShareInfo()
                }else{
                    Toast.makeText(context, "ابتدا مشخصات خود را وارد کنید.", Toast.LENGTH_SHORT).show()
                }

            }
        binding.share2.setOnClickListener{
            if (shPref.getString("name",null)!= null){
                Toast.makeText(context, R.string.matrix4, Toast.LENGTH_SHORT).show()
                secondMovieShareInfo()
            }else{
                Toast.makeText(context, "ابتدا مشخصات خود را وارد کنید.", Toast.LENGTH_SHORT).show()
            }

        }
        binding.share3.setOnClickListener{
            if (shPref.getString("name",null)!= null){
                Toast.makeText(context, R.string.singTow, Toast.LENGTH_SHORT).show()
                thirdMovieShareInfo()
            }else{
                Toast.makeText(context, "ابتدا مشخصات خود را وارد کنید.", Toast.LENGTH_SHORT).show()}

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