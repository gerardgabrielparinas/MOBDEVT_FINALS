package com.mobdevt.modevtfinals

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.mobdevt.modevtfinals.databinding.ActivityDifficultyBinding
import com.mobdevt.modevtfinals.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var gradAnim: AnimationDrawable
    private lateinit var constLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        bgAnimationStart()

        binding.btnStart.setOnClickListener {
            startDifficulty()

        }
    }

    private fun startDifficulty() {
        val imgLogo = findViewById<ImageView>(R.id.algoLogo)
        val intent = Intent(this, DifficultyActivity::class.java)
        var options = ActivityOptions.makeSceneTransitionAnimation(this, imgLogo, "logo_transition")
        startActivity(intent, options.toBundle())
    }

    private fun bgAnimationStart() {
        constLayout = binding.homeLayout
        gradAnim = constLayout.background as AnimationDrawable
        gradAnim.setEnterFadeDuration(2500)
        gradAnim.setExitFadeDuration(5000)
        gradAnim.start()
    }
}