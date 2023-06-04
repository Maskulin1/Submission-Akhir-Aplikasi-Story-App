package com.reihan.finalawalstory.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.reihan.finalawalstory.remote.database.ListStory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository):ViewModel() {
    val story: LiveData<PagingData<ListStory>> =
        mainRepository.getStory().cachedIn(viewModelScope)
}