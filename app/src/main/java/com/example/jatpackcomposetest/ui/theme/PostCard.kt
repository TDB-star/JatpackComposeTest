package com.example.jatpackcomposetest.ui.theme

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jatpackcomposetest.R
import com.example.jatpackcomposetest.domain.FeedPost
import com.example.jatpackcomposetest.domain.InteractionsItem
import com.example.jatpackcomposetest.domain.InteractionsType

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onViewsClickListener: (InteractionsItem) -> Unit,
    onShareClickListener: (InteractionsItem) -> Unit,
    onCommentClickListener: (InteractionsItem) -> Unit,
    onLikeClickListener: (InteractionsItem) -> Unit
) {
    Card(
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            PostCardHeader(feedPost)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = feedPost.postText,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = feedPost.contentImage),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(8.dp))
            PostCardInteractions(interactionItems = feedPost.interactions,
                onViewsClickListener = onViewsClickListener,
                onShareClickListener = onShareClickListener,
                onCommentClickListener = onCommentClickListener,
                onLikeClickListener = onLikeClickListener)
        }
    }
}

@Composable
private fun PostCardInteractions(
    interactionItems: List<InteractionsItem>,
    onViewsClickListener: (InteractionsItem) -> Unit,
    onShareClickListener: (InteractionsItem) -> Unit,
    onCommentClickListener: (InteractionsItem) -> Unit,
    onLikeClickListener: (InteractionsItem) -> Unit
) {
    Row {
        Row(modifier = Modifier.weight(1f)) {
            val viewsItem = interactionItems.getItemByType(InteractionsType.VIEWS)
            IconWithText(
                icon = Icons.Rounded.Face,
                text = viewsItem.count.toString(),
                onItemClickListener = {
                    onViewsClickListener(viewsItem)
                }
            )
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val sharesItem = interactionItems.getItemByType(InteractionsType.SHARES)
            val commentsItem = interactionItems.getItemByType(InteractionsType.COMMENTS)
            val likesItem = interactionItems.getItemByType(InteractionsType.LIKES)
            IconWithText(
                icon = Icons.Rounded.Share,
                text = sharesItem.count.toString(),
                onItemClickListener = {
                    onShareClickListener(sharesItem)
                }
            )

            IconWithText(
                icon = Icons.Rounded.AccountBox,
                text = commentsItem.count.toString(),
                onItemClickListener = {
                    onCommentClickListener(commentsItem)
                }
            )

            IconWithText(
                icon = Icons.Rounded.FavoriteBorder,
                text = likesItem.count.toString(),
                onItemClickListener = {
                    onLikeClickListener(likesItem)
                }
            )
        }
    }
}

private fun List<InteractionsItem>.getItemByType(type: InteractionsType): InteractionsItem {
    return this.find { it.type == type } ?: throw IllegalStateException("Item type not found")
}

@Composable
private fun IconWithText(
    icon: ImageVector,
    text: String,
    onItemClickListener: () -> Unit
) {
    Row(modifier = Modifier.clickable {
       onItemClickListener()
    }, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
private fun PostCardHeader(
    feedPost: FeedPost
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(id = feedPost.avatarResId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = feedPost.name, color = MaterialTheme.colorScheme.onPrimary)
            Text(text = feedPost.time, color = MaterialTheme.colorScheme.onSecondary)
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}
