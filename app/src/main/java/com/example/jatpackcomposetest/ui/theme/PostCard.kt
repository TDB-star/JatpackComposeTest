package com.example.jatpackcomposetest.ui.theme

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
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

@Composable
fun PostCard() {
    Column(modifier = Modifier.padding(8.dp)) {
        PostCardHeader()
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.post_text),
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.post),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(8.dp))
        PostCardInteractions()
    }
}

@Composable
private fun PostCardInteractions() {
    Row {
        Row(modifier = Modifier.weight(1f)) {
           IconWithText(
               icon = Icons.Rounded.Face,
               text = "916")
        }
        Row(modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween) {
            IconWithText(
                icon = Icons.Rounded.Share,
                text = "7")

            IconWithText(
                icon = Icons.Rounded.AccountBox,
                text = "8")

            IconWithText(
                icon = Icons.Rounded.FavoriteBorder,
                text = "23")
        }
    }
}

@Composable
private fun IconWithText(
    icon: ImageVector,
    text: String,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon ,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text,
            color = MaterialTheme.colorScheme.onSecondary)
    }
}

@Composable
private fun PostCardHeader() {
    Card {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.giorgio_encinas),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "/dev/null", color = MaterialTheme.colorScheme.onPrimary)
                Text(text = "14:00", color = MaterialTheme.colorScheme.onSecondary)
            }
            Icon(
                imageVector = Icons.Rounded.MoreVert,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Preview
@Composable
private fun PostCardLight() {
    JatpackComposeTestTheme(darkTheme = false, dynamicColor = false) {
        PostCard()
    }
}

@Preview
@Composable
private fun PostCardDark() {
    JatpackComposeTestTheme(darkTheme = true, dynamicColor = false) {
        PostCard()
    }
}