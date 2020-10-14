package dev.alexmorgan.unbearable2.main_activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.alexmorgan.unbearable2.R
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class BearListFragment : Fragment(R.layout.main_fragment) {
    @Inject
    internal lateinit var bearAdapter: BearAdapter

    @Inject
    lateinit var bearListPreference: BearListPreference

    private val bearListViewModel: BearListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bear_list_recycler.adapter = bearAdapter
        this.setLayoutManagerFromPreference()

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_bear_list, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.menu_item_show_bear_list).isVisible =
            bearListPreference.formatPreference != BearListPreference.Format.LIST
        menu.findItem(R.id.menu_item_show_bear_grid).isVisible =
            bearListPreference.formatPreference != BearListPreference.Format.GRID
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_show_bear_list -> {
                bearListPreference.formatPreference = BearListPreference.Format.LIST
                this.setLayoutManagerFromPreference()
                requireActivity().invalidateOptionsMenu()
                true
            }
            R.id.menu_item_show_bear_grid -> {
                bearListPreference.formatPreference = BearListPreference.Format.GRID
                this.setLayoutManagerFromPreference()
                requireActivity().invalidateOptionsMenu()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setLayoutManagerFromPreference() {
        when (bearListPreference.formatPreference) {
            BearListPreference.Format.GRID -> {
                bear_list_recycler.layoutManager = GridLayoutManager(requireContext(), 2)
            }
            BearListPreference.Format.LIST -> {
                bear_list_recycler.layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }
}