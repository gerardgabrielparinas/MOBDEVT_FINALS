package com.mobdevt.modevtfinals

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.mobdevt.modevtfinals.databinding.ActivityEasyRoundBinding
import com.mobdevt.modevtfinals.databinding.ActivityHardBinding
import com.mobdevt.modevtfinals.util.MainHelper

class EasyRoundActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEasyRoundBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        binding = ActivityEasyRoundBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        lifecycle.addObserver(MainObserver())

        val viewModel by viewModels<MainViewModel>()

        binding.btnNext.setOnClickListener{
            viewModel.checkAnswer(binding.answerInput.text.toString(), 1)
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

        binding.btnSubmit.setOnClickListener {
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