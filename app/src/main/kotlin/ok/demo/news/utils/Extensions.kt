package ok.demo.news.utils

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ok.demo.news.BuildConfig
import ok.demo.news.view_model.BaseViewModel

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

fun BaseViewModel.dbg(message: String){
    if (BuildConfig.DEBUG) Log.d(defaultTag, message)
}

fun BaseViewModel.dbgc(message: String){
    if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName, message)
}

