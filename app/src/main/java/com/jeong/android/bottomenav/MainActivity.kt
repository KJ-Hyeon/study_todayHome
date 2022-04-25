package com.jeong.android.bottomenav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jeong.android.bottomenav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottmo_nav)
        val navController = supportFragmentManager.findFragmentById(R.id.main_frame_container)?.findNavController()
        navController?.let {
            // 바텀네비게이션 과 네비게이션 컨트롤? 을 묶어주는 역할
            bottomNavigation.setupWithNavController(it)
        }
    }
}
