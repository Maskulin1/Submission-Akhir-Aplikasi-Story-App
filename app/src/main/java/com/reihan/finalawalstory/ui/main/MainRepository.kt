package com.reihan.finalawalstory.ui.main

import androidx.lifecycle.LiveData
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.reihan.finalawalstory.remote.data.StoryPagingSource
import com.reihan.finalawalstory.remote.data.StoryRemoteMediator
import com.reihan.finalawalstory.remote.database.ListStory
import com.reihan.finalawalstory.remote.database.StoryDatabase
import javax.inject.Inject

class MainRepository @Inject constructor(private val storyDatabase: StoryDatabase, private val mainService: MainService){
    fun getStory(): LiveData<PagingData<ListStory>> {
        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            remoteMediator = StoryRemoteMediator(storyDatabase, mainService),
            pagingSourceFactory = {
                StoryPagingSource(mainService)
                storyDatabase.storyDao().getAllStory()
            }
        ).liveData
    }
}