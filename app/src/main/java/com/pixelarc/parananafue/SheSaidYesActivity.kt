package com.pixelarc.parananafue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pixelarc.parananafue.databinding.ActivitySheSaidYesBinding

class SheSaidYesActivity : AppCompatActivity() {
    lateinit var binding: ActivitySheSaidYesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySheSaidYesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}