package com.jeong.android.bottomenav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jeong.android.bottomenav.databinding.FragmentInteriorBinding

class InteriorFragment: Fragment() {

    private lateinit var binding : FragmentInteriorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInteriorBinding.inflate(inflater, container, false)
        return binding.root
    }
}