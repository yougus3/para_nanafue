package com.pixelarc.parananafue

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.FirebaseApp
import com.pixelarc.parananafue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val img: ImageView? = findViewById(R.id.ivNana)
        var count = 0

        binding.ivNana.setOnClickListener {
            if (count == 0) {
                count = 1
                audio(R.raw.pato_0)
                img?.setImageResource(R.drawable.nana_1)
            } else if (count == 1) {
                count = 2
                audio(R.raw.pato_1)
                img?.setImageResource(R.drawable.nana_2)
            } else {
                count = 0
                audio(R.raw.pato_2)
                img?.setImageResource(R.drawable.nana_0)
            }
        }

        binding.btnYes.setOnClickListener {
            val i = Intent(this, SheSaidYesActivity::class.java)
            startActivity(i)
        }

        binding.btnNo.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Mensaje")
            alert.setMessage("Estará aquí cuando gustes \uD83E\uDD13")
            alert.setPositiveButton("Ta' güeno", null)
            alert.show()
        }
    }

    fun audio(raw: Int) {
        val mediaPlayer: MediaPlayer? = MediaPlayer.create(this, raw)
        mediaPlayer?.start()
    }
}