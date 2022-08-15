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