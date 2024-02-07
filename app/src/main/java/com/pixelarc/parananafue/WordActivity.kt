package com.pixelarc.parananafue

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.pixelarc.parananafue.databinding.ActivityWordBinding

class WordActivity : AppCompatActivity() {
    lateinit var binding: ActivityWordBinding
    val functions = Functions()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWordBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        FirebaseApp.initializeApp(this)

        val db = Firebase.firestore
        val password = binding.editTextWord
        binding.btnGo.setOnClickListener {
            binding.btnGo.isEnabled = false
            binding.btnGo.isClickable = false
            val docRef = db.collection("entrada").document("GSJBWuO1OvnmtZxRp27n")
            docRef.get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        Log.d(TAG, "DocumentSnapshot data: ${document.data}")

                        if (password.text.toString().isEmpty()) {
                            functions.snackbar(this, view, "Escribe la palabra (del señor no)")
                        } else {
                            if (document.data?.get("password")
                                    .toString() == password.text.toString()
                            ) {
                                finish()
                                val i = Intent(this, MainActivity::class.java)
                                startActivity(i)
                            } else {
                                functions.snackbar(this, view, "Palabra incorrecta")
                            }
                        }

                    } else {
                        functions.snackbar(this, view, "No se encontró el documento")
                        Log.d(TAG, "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    functions.snackbar(this, view, "Fallo:  ${exception}")
                    Log.d(TAG, "get failed with ", exception)
                }
        }
    }
}