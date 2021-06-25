package com.szyds.myfbvideodownload

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.szyds.myfbvideodownload.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil.setContentView

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)


    }

}