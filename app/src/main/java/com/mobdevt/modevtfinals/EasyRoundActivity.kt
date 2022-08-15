package com.mobdevt.modevtfinals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mobdevt.modevtfinals.databinding.ActivityEasyRoundBinding
import com.mobdevt.modevtfinals.databinding.ActivityHardBinding

class EasyRoundActivity : AppCompatActivity() {

    //private val tvQuestion by lazy {binding.tvQuestion}
    private lateinit var binding : ActivityEasyRoundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEasyRoundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel by viewModels<MainViewModel>()

        viewModel.loadQuestion(1, 0)

        binding.btnNext.setOnClickListener{
            viewModel.checkAnswer(binding.answerInput.toString(),1)
            binding.answerInput.text?.clear()
        }
        viewModel.question.observe(this){
            binding.txtQuestion.text = it
        }

        viewModel.checkAnswer(binding.answerInput.toString(),1)

    }
}