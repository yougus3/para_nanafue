package com.pixelarc.parananafue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.pixelarc.parananafue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnNo.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Mensaje")
            //alert.setPositiveButton("Ta' güeno", null)
            alert.setView(R.layout.negative_response)
            alert.show()
        }
    }
}