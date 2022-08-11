package com.mobdevt.modevtfinals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mobdevt.modevtfinals.databinding.ActivityEasyRoundBinding
import com.mobdevt.modevtfinals.viewModel.MainViewModel

class EasyRoundActivity : AppCompatActivity() {

    private lateinit var binding:ActivityEasyRoundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEasyRoundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel by viewModels<MainViewModel>()
    }
}