package com.cmps312.todoapp.utils

import android.content.Context
import android.widget.Toast

fun displayMessage(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}
