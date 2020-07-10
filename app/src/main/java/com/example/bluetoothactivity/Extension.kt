package com.example.bluetoothactivity

import android.content.Context
import android.widget.Toast

fun Context.showToast(context: Context, messsage:String){
    Toast.makeText(context, messsage, Toast.LENGTH_LONG).show()
}