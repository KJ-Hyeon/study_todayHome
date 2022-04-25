package com.jeong.android.bottomenav

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jeong.android.bottomenav.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {

    private lateinit var binding: FragmentStoreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreBinding.inflate(inflater, container, false)
        return binding.root
    }
}