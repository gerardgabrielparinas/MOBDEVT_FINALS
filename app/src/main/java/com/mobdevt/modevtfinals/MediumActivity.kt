package com.mobdevt.modevtfinals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobdevt.modevtfinals.databinding.ActivityMainBinding

class MediumActivity : AppCompatActivity() {

    //private val tvQuestion by lazy {binding.tvQuestion}
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        }

}