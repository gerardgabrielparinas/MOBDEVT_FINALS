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

class EasyRoundActivity : AppCompatActivity() {

    //private val tvQuestion by lazy {binding.tvQuestion}
    private lateinit var binding : ActivityEasyRoundBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        binding = ActivityEasyRoundBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

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