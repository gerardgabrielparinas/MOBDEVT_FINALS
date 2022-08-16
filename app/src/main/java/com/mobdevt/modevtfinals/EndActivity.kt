package com.mobdevt.modevtfinals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import com.mobdevt.modevtfinals.databinding.ActivityEndBinding
import com.mobdevt.modevtfinals.util.MainHelper

class EndActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEndBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        binding = ActivityEndBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val viewModel by viewModels<MainViewModel>()

        binding.txtScore.text = MainHelper.getScore().toString()

        binding.btnRestart.setOnClickListener {
            viewModel.resetProgress()
            val intent = Intent(this, DifficultyActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_out)

        }

        binding.btnShare.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Thank you for taking the DSTALGO quiz!" +
                "\nYour final score is:" +
                "\n${MainHelper.getScore()} pts" +
                "\nGreat Job!")
                type = "text/plain"
            }
            startActivity(intent)
        }
    }
}