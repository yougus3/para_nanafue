package com.pixelarc.parananafue

import android.content.DialogInterface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.pixelarc.parananafue.databinding.ActivitySheSaidYesBinding

class SheSaidYesActivity : AppCompatActivity() {
    lateinit var binding: ActivitySheSaidYesBinding
    var count = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySheSaidYesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnPerrito.setOnClickListener {
            count++
            alert(R.layout.view_perrito)
            audio(R.raw.cristal)
        }

        binding.btnGirasol.setOnClickListener {
            count++
            alert(R.layout.view_girasol)
            audio(R.raw.gema)
        }

        binding.btnCorazon.setOnClickListener {
            if (count > 2) {
                audio(R.raw.corazon)
                val alertFeliz = AlertDialog.Builder(this)
                alertFeliz.setView(R.layout.view_corazon_condicion)
                alertFeliz.setNegativeButton("Oki", { dialogInterface, which ->
                    audio(R.raw.ninios)
                })
                alertFeliz.show()

            } else {
                alert(R.layout.view_corazon)
            }
        }
    }

    private fun audio(raw: Int) {
        val mediaPlayer: MediaPlayer? = MediaPlayer.create(this, raw)
        mediaPlayer?.start()
    }

    private fun alert(view: Int) {
        val alert = AlertDialog.Builder(this)
        alert.setView(view)
        alert.setNegativeButton("Oki", null)
        alert.show()
    }
}