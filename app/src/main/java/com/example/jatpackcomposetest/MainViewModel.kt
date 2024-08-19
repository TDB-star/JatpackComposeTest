package com.example.jatpackcomposetest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jatpackcomposetest.domain.FeedPost
import com.example.jatpackcomposetest.domain.InteractionsItem

class MainViewModel: ViewModel() {

    private val _feedPost = MutableLiveData<FeedPost>(FeedPost())
    val feedPost: LiveData<FeedPost> = _feedPost


    fun updateCount(item: InteractionsItem) {
        val oldInteractions = feedPost.value?.interactions ?: throw IllegalStateException("Item not found")
        val newInteractions = oldInteractions.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        _feedPost.value = _feedPost.value?.copy(interactions = newInteractions)
    }
}