package com.example.movieapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.movieapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonClickListener()
    }

    private fun buttonClickListener() {
       binding.register.setOnClickListener{
           if (isfielsFullAndCorrect()){
                saveInfo()
           }
       }
    }
    private fun saveInfo() {
       var shPref :SharedPreferences = requireActivity().getSharedPreferences("personalInformation", Context.MODE_PRIVATE)
        var editor = shPref.edit()
        editor.putString("name", binding.fullName.text.toString())
        editor.putString("userName", binding.userName.text.toString())
        editor.putString("email", binding.email.text.toString())
        editor.putString("password", binding.password.text.toString())
        editor.putString("phonNumber", binding.phone.text.toString())
        editor.apply()
    }
    fun isfielsFullAndCorrect():Boolean {
        if (binding.fullName.text.isNullOrBlank()) {
            binding.fullName.error = "این فیلد را پر کنید."
            return false
        }
        if (binding.userName.text.isNullOrBlank()) {
            binding.userName.error = "این فیلد را پر کنید."
            return false
        }
        if (binding.email.text.isNullOrBlank()) {
            binding.email.error = "این فیلد را پر کنید."
            return false
        }
        if (binding.password.text.isNullOrBlank()) {
            binding.password.error = "این فیلد را پر کنید."
            return false
        }
        if (binding.phone.text.isNullOrBlank()) {
            binding.phone.error = "این فیلد را پر کنید."
            return false
        }
        return true
    }
}