package com.mobdevt.modevtfinals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

import com.mobdevt.modevtfinals.databinding.ActivityMainBinding
import com.mobdevt.modevtfinals.databinding.ActivityMediumBinding
import com.mobdevt.modevtfinals.util.MainHelper
import com.mobdevt.modevtfinals.viewModel.MainViewModel

class MediumActivity : AppCompatActivity() {

    //private val tvQuestion by lazy {binding.tvQuestion}
    private lateinit var binding : ActivityMediumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel by viewModels<MainViewModel>()

        viewModel.loadQuestion(2, 0)

        binding.btnNext.setOnClickListener{


        }
        viewModel.question.observe(this){
            binding.txtQuestion.text = it
        }

        viewModel.checkAnswer(binding.answerInput.toString(),2)

    }

}