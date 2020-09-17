package dev.alexmorgan.unbearable2.main_activity

import android.os.Bundle
import dev.alexmorgan.unbearable2.BaseActivity
import dev.alexmorgan.unbearable2.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
