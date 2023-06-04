package com.reihan.finalawalstory.remote.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.reihan.finalawalstory.remote.database.ListStory
import com.reihan.finalawalstory.ui.main.MainService

class StoryPagingSource(private val mainService: MainService) : PagingSource<Int, ListStory>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListStory> {
        return try {
            val page = params.key ?: INITIAL_PAGE_INDEX
            val responseData = mainService.fetchStory(page, params.loadSize).listStory

            LoadResult.Page(
                data = responseData,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (responseData.isEmpty()) null else page + 1
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ListStory>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }
}