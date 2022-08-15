package com.mobdevt.modevtfinals

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.os.HardwarePropertiesManager
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.mobdevt.modevtfinals.databinding.ActivityDifficultyBinding


class DifficultyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDifficultyBinding
    private lateinit var gradAnim: AnimationDrawable
    private lateinit var constLayout: ConstraintLayout

    private val btnEasy by lazy {binding.btnEasy}
    private val btnMedium by lazy {binding.btnMid}
    private val btnHard by lazy {binding.btnHard}

    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        binding = ActivityDifficultyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        bgAnimationStart()

        btnEasy.setOnClickListener {
            val intent = Intent(this, EasyRoundActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)

        }
        btnMedium.setOnClickListener {
            val intent = Intent(this, MediumActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)

        }
        btnHard.setOnClickListener {
            val intent = Intent(this, HardRoundActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)

        }
    }

    private fun bgAnimationStart() {
        constLayout = binding.difficultyLayout
        gradAnim = constLayout.background as AnimationDrawable
        gradAnim.setEnterFadeDuration(2500)
        gradAnim.setExitFadeDuration(5000)
        gradAnim.start()
    }
}