package com.mobdevt.modevtfinals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.mobdevt.modevtfinals.databinding.ActivityHardBinding

import com.mobdevt.modevtfinals.databinding.ActivityMainBinding
import com.mobdevt.modevtfinals.databinding.ActivityMediumBinding
import com.mobdevt.modevtfinals.util.MainHelper

class HardRoundActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHardBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        binding = ActivityHardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val viewModel by viewModels<MainViewModel>()

        binding.btnNext3.setOnClickListener{
            viewModel.checkAnswer(binding.answerInput3.text.toString() ,3)
            binding.answerInput3.text?.clear()
            Log.i("DEBUG", "Last Question? ${MainHelper.getLast()}")
            when{
                MainHelper.getLast() -> {
                    binding.btnNext3.setEnabled(false)
                    binding.btnNext3.isVisible = false
                    Log.i("DEBUG", "Button is HIDDEN!")
                }
            }
        }

        binding.btnSubmitHard.setOnClickListener {
            viewModel.checkLast(binding.answerInput3.text.toString())
            binding.answerInput3.text?.clear()
            val intent = Intent(this, EndActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_out)
        }

        viewModel.question.observe(this){
            binding.txtQuestion3.text = it
        }
    }
}