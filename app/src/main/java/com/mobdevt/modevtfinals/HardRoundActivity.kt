package com.mobdevt.modevtfinals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mobdevt.modevtfinals.databinding.ActivityHardBinding

import com.mobdevt.modevtfinals.databinding.ActivityMainBinding
import com.mobdevt.modevtfinals.databinding.ActivityMediumBinding
import com.mobdevt.modevtfinals.util.MainHelper

class HardRoundActivity : AppCompatActivity() {

    //private val tvQuestion by lazy {binding.tvQuestion}
    private lateinit var binding : ActivityHardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel by viewModels<MainViewModel>()

        viewModel.loadQuestion(3, 0)

        binding.btnNext3.setOnClickListener{
            viewModel.checkAnswer(binding.answerInput3.toString(),3)
            binding.answerInput3.text?.clear()
        }

        binding.btnSubmitHard.setOnClickListener {
            viewModel.checkLast(binding.answerInput3.toString())
            val intent = Intent(this, EndActivity::class.java)
            startActivity(intent)
        }

        viewModel.question.observe(this){
            binding.txtQuestion3.text = it
        }
    }

}