package com.pixelarc.parananafue

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.pixelarc.parananafue.databinding.ActivityWordBinding

class WordActivity : AppCompatActivity() {
    lateinit var binding: ActivityWordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWordBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        FirebaseApp.initializeApp(this)

        val db = Firebase.firestore
        val password = binding.editTextWord
        binding.btnGo.setOnClickListener {
            val docRef = db.collection("entrada").document("GSJBWuO1OvnmtZxRp27n")
            docRef.get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        Log.d(TAG, "DocumentSnapshot data: ${document.data}")

                        if (password.text.toString().isEmpty()) {
                            alert("Escribe la palabra (del señor no)")
                        } else {
                            if (document.data?.get("word").toString() == password.text.toString()) {
                                finish()
                                val i = Intent(this, MainActivity::class.java)
                                startActivity(i)
                            } else {
                                alert("Palabra incorrecta")
                            }
                        }

                    } else {
                        alert("No se encontró el documento")
                        Log.d(TAG, "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    alert("Fallo:  ${exception}")
                    Log.d(TAG, "get failed with ", exception)
                }
        }

        binding.btnInfo?.setOnClickListener {
            val i = Intent(this, InfoActivity::class.java)
            startActivity(i)
        }
    }

    private fun alert(message: String) {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Error")
        alert.setMessage(message)
        alert.setNegativeButton("Oki", null)
        alert.show()
    }
}