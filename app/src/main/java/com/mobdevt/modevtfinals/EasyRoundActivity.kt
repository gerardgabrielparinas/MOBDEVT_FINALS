package com.mobdevt.modevtfinals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mobdevt.modevtfinals.databinding.ActivityEasyRoundBinding
import com.mobdevt.modevtfinals.databinding.ActivityHardBinding
import com.mobdevt.modevtfinals.util.MainHelper

class EasyRoundActivity : AppCompatActivity() {

    //private val tvQuestion by lazy {binding.tvQuestion}
    private lateinit var binding : ActivityEasyRoundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEasyRoundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(MainObserver())

        val viewModel by viewModels<MainViewModel>()

        binding.btnNext.setOnClickListener{
            if (MainHelper.getLast() == false) {
                viewModel.checkAnswer(binding.answerInput.toString(),3)
                binding.answerInput.text?.clear()
            }
            else if (MainHelper.getLast() == true) {
                val intent = Intent(this, EndActivity::class.java)
                startActivity(intent)
            }
        }

        viewModel.question.observe(this){
            binding.txtQuestion.text = it
        }
    }
}