package dev.alexmorgan.unbearable2.main_activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.alexmorgan.unbearable2.R
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class BearListFragment : Fragment(R.layout.main_fragment) {
    @Inject
    internal lateinit var bearAdapter: BearAdapter

    private val bearListViewModel: BearListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bear_list_recycler.adapter = bearAdapter

        bearListViewModel.viewState().observe(viewLifecycleOwner) {
            when (it) {
                is Loading -> {

                }
                is Content -> {
                    bearAdapter.bears = it.bears
                }
            }
        }
    }
}