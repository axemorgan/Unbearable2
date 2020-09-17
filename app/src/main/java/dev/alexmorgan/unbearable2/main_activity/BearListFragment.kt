package dev.alexmorgan.unbearable2.main_activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dev.alexmorgan.unbearable2.R
import kotlinx.android.synthetic.main.main_fragment.*

@AndroidEntryPoint
class BearListFragment : Fragment(R.layout.main_fragment) {

//    @Inject lateinit var message: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main_fragment_text_view.text = ""//message
    }
}