package ok.demo.news.utils

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ok.demo.news.BuildConfig

const val defaultTag = "NewsApp"

fun AppCompatActivity.dbg(message: String){
    if (BuildConfig.DEBUG) Log.d(defaultTag, message)
}

fun AppCompatActivity.dbgc(message: String){
    if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName, message)
}

fun Fragment.dbg(message: String){
    if (BuildConfig.DEBUG) Log.d(defaultTag, message)
}

fun Fragment.dbgc(message: String){
    if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName, message)
}