package com.mobdevt.modevtfinals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobdevt.modevtfinals.databinding.ActivityMainBinding
import com.mobdevt.modevtfinals.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {

        }
    }
}