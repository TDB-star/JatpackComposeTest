package com.example.jatpackcomposetest.domain

import com.example.jatpackcomposetest.R

 data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val commentText: String = "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.",
    val avatarId: Int = R.drawable.utilisateur,
    val commentDate: String = "14:00"
)