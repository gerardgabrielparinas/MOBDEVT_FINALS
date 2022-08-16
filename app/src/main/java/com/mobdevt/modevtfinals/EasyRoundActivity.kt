package com.mobdevt.modevtfinals

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import com.mobdevt.modevtfinals.databinding.ActivityEasyRoundBinding
import com.mobdevt.modevtfinals.databinding.ActivityHardBinding
import com.mobdevt.modevtfinals.util.MainHelper

class EasyRoundActivity : AppCompatActivity() {

    //private val tvQuestion by lazy {binding.tvQuestion}
    private lateinit var binding : ActivityEasyRoundBinding
    private var score = 0


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
        }

        binding.btnSubmit.setOnClickListener {
            //viewModel.checkAnswer(binding.answerInput.text.toString(), 1)
            viewModel.checkLast(binding.answerInput.text.toString())
            binding.answerInput.text?.clear()
            val intent = Intent(this, EndActivity::class.java)
            startActivity(intent)
            finish()
        }

        viewModel.question.observe(this){
            binding.txtQuestion.text = it
        }

//Save for demo - Jems
        viewModel.score.observe(this) {
            binding.txtScore.text = "$it"
        }
    }

    private fun saveScore(){
//blank for now, please refer to activity 06
    }


}