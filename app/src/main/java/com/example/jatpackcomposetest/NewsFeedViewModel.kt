package com.example.jatpackcomposetest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jatpackcomposetest.domain.FeedPost
import com.example.jatpackcomposetest.domain.InteractionsItem
import com.example.jatpackcomposetest.navigation.NavigationItem
import com.example.jatpackcomposetest.ui.theme.NewsFeedScreenState

class NewsFeedViewModel: ViewModel() {

    private val sourceList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }

    private val initialState = NewsFeedScreenState.Posts(posts = sourceList)

    private val _screenState = MutableLiveData<NewsFeedScreenState>(initialState)
    val screenState: LiveData<NewsFeedScreenState> = _screenState

    private val _selectedNavItem = MutableLiveData<NavigationItem>(NavigationItem.Home)
    val selectedNavItem: LiveData<NavigationItem> = _selectedNavItem

    fun selectNavItem(item: NavigationItem) {
        _selectedNavItem.value = item
    }

    fun updateCount(feedPost: FeedPost, item: InteractionsItem) {
        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        val oldInteractions = feedPost.interactions
        val newInteractions = oldInteractions.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(interactions = newInteractions)
         val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
        _screenState.value = NewsFeedScreenState.Posts(posts = newPosts)
    }

    fun remove(feedPost: FeedPost) {
        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        oldPosts.remove(feedPost)
        _screenState.value = NewsFeedScreenState.Posts(posts = oldPosts)
    }
}