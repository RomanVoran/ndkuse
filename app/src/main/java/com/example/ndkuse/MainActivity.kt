package com.example.ndkuse

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nativelib.NativeLib

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ndkString = "c++ report from MainActivity.class - ${getStringJNI()}"
        val localString = "c++ report from NativeLib.class - ${NativeLib().stringFromJNI()}"

        Log.d("TEST_TAG", ndkString)
        Log.d("TEST_TAG", localString)

        findViewById<TextView>(R.id.text_view).text = localString
        findViewById<TextView>(R.id.text_view2).text = ndkString

    }

    external fun getStringJNI():String?

    companion object{
        init {
            System.loadLibrary("nativelib")
        }
    }

}