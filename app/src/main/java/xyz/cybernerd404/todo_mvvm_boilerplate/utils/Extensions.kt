package xyz.cybernerd404.todo_mvvm_boilerplate.utils

import android.util.Log
import androidx.viewbinding.BuildConfig

/** for debugging purpose*/
fun debug(message: String){
    if (BuildConfig.DEBUG){
        Log.d("debug", message)
    }
}