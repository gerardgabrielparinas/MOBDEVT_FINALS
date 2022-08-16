package com.mobdevt.modevtfinals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mobdevt.modevtfinals.databinding.ActivityEndBinding
import com.mobdevt.modevtfinals.util.MainHelper

class EndActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEndBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel by viewModels<MainViewModel>()
        //viewModel.loadScore()

        binding.txtScore.text = MainHelper.getScore().toString()

        binding.btnRestart.setOnClickListener {
            viewModel.resetProgress()
            val intent = Intent(this, DifficultyActivity::class.java)
            startActivity(intent)
        }

        binding.btnShare.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Thank you for taking the DSTALGO quiz!" +
                "\nYour final score is:" +
                "\n${viewModel.score.value.toString()} pts" +
                "\nGreat Job!")
                type = "text/plain"
            }
            startActivity(intent)
        }
        //binding.txtScore.text = "${viewModel.score.value.toString()}"

//        viewModel.score.observe(this) {
//            binding.txtScore.text = "$it"
//        }
    }
}