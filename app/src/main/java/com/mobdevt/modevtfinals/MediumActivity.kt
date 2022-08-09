package com.mobdevt.modevtfinals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

import com.mobdevt.modevtfinals.databinding.ActivityMainBinding
import com.mobdevt.modevtfinals.databinding.ActivityMediumBinding
import com.mobdevt.modevtfinals.util.MainHelper

class MediumActivity : AppCompatActivity() {

    //private val tvQuestion by lazy {binding.tvQuestion}
    private lateinit var binding : ActivityMediumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediumBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val viewModel by viewModels<MainViewModel>()
//
//
//        viewModel.question.observe(this){
//            binding.txtQuestion.text = it
//        }
//
//        if(viewModel.answer == binding.answerInput){
//            //viewModel.score += 1
//        }
//
//        }
    }
}