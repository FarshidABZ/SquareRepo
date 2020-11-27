package com.farshidabz.squarerepo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.farshidabz.squarerepo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SquareRepo)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}