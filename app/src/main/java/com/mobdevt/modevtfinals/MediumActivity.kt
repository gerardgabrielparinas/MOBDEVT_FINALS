package com.mobdevt.modevtfinals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.core.view.isVisible

import com.mobdevt.modevtfinals.databinding.ActivityMainBinding
import com.mobdevt.modevtfinals.databinding.ActivityMediumBinding
import com.mobdevt.modevtfinals.util.MainHelper

class MediumActivity : AppCompatActivity() {

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
            Log.i("DEBUG", "Last Question? ${MainHelper.getLast()}")
            when{
                MainHelper.getLast() -> {
                    binding.btnNext.setEnabled(false)
                    binding.btnNext.isVisible = false
                    Log.i("DEBUG", "Button is HIDDEN!")
                }
            }
        }

        binding.btnSubmitMedium.setOnClickListener {
            viewModel.checkLast(binding.answerInput.text.toString())
            binding.answerInput.text?.clear()
            val intent = Intent(this, EndActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_out)
        }

        viewModel.question.observe(this){
            binding.txtQuestion.text = it
        }

    }

}