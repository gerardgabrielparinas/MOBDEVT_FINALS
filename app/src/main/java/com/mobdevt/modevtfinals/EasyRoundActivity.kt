package com.mobdevt.modevtfinals

import android.content.Intent
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

        binding.btnSubmit.setOnClickListener {
            viewModel.checkLast(binding.answerInput.toString())
            val intent = Intent(this, EndActivity::class.java)
            startActivity(intent)
        }

        viewModel.question.observe(this){
            binding.txtQuestion.text = it
        }
    }
}