package com.mobdevt.modevtfinals

import android.content.Intent
import android.os.Bundle
import android.os.HardwarePropertiesManager
import androidx.appcompat.app.AppCompatActivity
import com.mobdevt.modevtfinals.databinding.ActivityDifficultyBinding


class DifficultyActivity : AppCompatActivity() {


    private val btnEasy by lazy {binding.btnEasy}
    private val btnMedium by lazy {binding.btnMedium}
    private val btnHard by lazy {binding.btnHard}



    private lateinit var binding: ActivityDifficultyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDifficultyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnEasy.setOnClickListener {
            val intent = Intent(this, EasyRoundActivity::class.java)
            startActivity(intent)
        }
        btnMedium.setOnClickListener {
            val intent = Intent(this, MediumActivity::class.java)
            startActivity(intent)
        }
        btnHard.setOnClickListener {
            //val intent = Intent(this, HardActivity::class.java)
            startActivity(intent)
        }
    }
}