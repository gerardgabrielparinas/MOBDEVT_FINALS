package com.mobdevt.modevtfinals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels

import com.mobdevt.modevtfinals.databinding.ActivityMainBinding
import com.mobdevt.modevtfinals.databinding.ActivityMediumBinding
import com.mobdevt.modevtfinals.util.MainHelper

class MediumActivity : AppCompatActivity() {

    //private val tvQuestion by lazy {binding.tvQuestion}
    private lateinit var binding : ActivityMediumBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        binding = ActivityMediumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val viewModel by viewModels<MainViewModel>()

        binding.btnNext.setOnClickListener{
            viewModel.checkAnswer(binding.answerInput.text.toString(),2)
            binding.answerInput.text?.clear()
        }

        viewModel.question.observe(this){
            binding.txtQuestion.text = it
        }
        //Save for demo - Jems
        viewModel.score.observe(this) {
            binding.txtMidScore?.text = "$it"
        }

    }

}