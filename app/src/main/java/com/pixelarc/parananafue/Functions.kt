package com.pixelarc.parananafue

import android.content.Context
import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar

class Functions {
    fun snackbar(context: Context, view: View, message: String) {
        Snackbar.make(
            context,
            view,
            message,
            Snackbar.LENGTH_SHORT
        )
            .setTextColor(Color.parseColor("#FFFFFF"))
            .setBackgroundTint(Color.parseColor("#00337F"))
            .show()
    }
}