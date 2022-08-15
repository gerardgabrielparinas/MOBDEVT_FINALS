package com.mobdevt.modevtfinals

import android.content.Intent
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

        val viewModel by viewModels<MainViewModel>()

        viewModel.loadQuestion(2, 0)

        binding.btnNext.setOnClickListener{
            viewModel.checkAnswer(binding.answerInput.toString(),2)
            binding.answerInput.text?.clear()
        }

        binding.btnSubmitMedium.setOnClickListener {
            viewModel.checkLast(binding.answerInput.toString())
            val intent = Intent(this, EndActivity::class.java)
            startActivity(intent)
        }

        viewModel.question.observe(this){
            binding.txtQuestion.text = it
        }
    }

}