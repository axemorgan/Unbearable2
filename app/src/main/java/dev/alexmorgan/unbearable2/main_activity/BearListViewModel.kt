package dev.alexmorgan.unbearable2.main_activity

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class BearListViewModel @ViewModelInject constructor(bearSource: BearSource) : ViewModel() {

    fun viewState(): LiveData<BearListViewState> = viewState

    private val viewState: MutableLiveData<BearListViewState> = MutableLiveData()

    init {
        viewState.postValue(Loading)
        viewModelScope.launch {
            Thread.sleep(1000) //Artificial wait time...
            viewState.postValue(Content(bearSource.getAllBears()))
        }
    }
}

sealed class BearListViewState
object Loading : BearListViewState()
data class Content(val bears: List<Bear>) : BearListViewState()
