package com.example.jatpackcomposetest.ui.theme

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jatpackcomposetest.InstagramModel
import com.example.jatpackcomposetest.R

@Composable
fun InstagramProfileCard(
    model: InstagramModel,
    onFollowedButtonClickListener: (InstagramModel) -> Unit
) {

    Card(modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(topStart = 4.dp,
        topEnd = 4.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.onBackground,
            containerColor = MaterialTheme.colorScheme.background
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
    ) {
        InstagramProfileTitles(model = model) {
            onFollowedButtonClickListener(model)
        }
    }
}


@Composable
private fun InstagramProfileTitles(
    model: InstagramModel,
    clickListener: () -> Unit,

) {
    Column(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_instagram),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.White))

            UserStatistics("Posts", "6,950")
            UserStatistics("Followers", "4M")
            UserStatistics("Following", "150")
        }
        Text(text = "Instagram ${model.id}", fontSize = 32.sp)
        Text(text = "#${model.title}", fontSize = 14.sp)
        Text(text = "www.facebook.com/emotional_health",
            fontSize = 12.sp,
            textDecoration = TextDecoration.Underline
        )
        Button(onClick = { clickListener()},
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (model.isFollowed) {
                    MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
                } else {
                    MaterialTheme.colorScheme.primary
                }
            )) {
            val text = if (model.isFollowed) {
                "Unfollow"
            } else {
                "Follow"
            }
            Text(text = text)
        }
    }
}

@Composable
private fun UserStatistics(
    title: String,
    value: String
) {
    Column(modifier = Modifier
        .height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {
        Text(text = value, fontSize = 24.sp, textAlign = TextAlign.Center)
        Text(text = title, textAlign = TextAlign.Center)
    }
}
