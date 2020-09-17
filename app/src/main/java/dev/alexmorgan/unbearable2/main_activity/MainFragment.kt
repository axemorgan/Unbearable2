package dev.alexmorgan.unbearable2.main_activity

import android.os.Bundle
import android.view.View
import dev.alexmorgan.unbearable2.BaseFragment
import dev.alexmorgan.unbearable2.R
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : BaseFragment() {

    @Inject lateinit var message: String

    override val layoutId = R.layout.main_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main_fragment_text_view.text = message
    }
}