package com.example.jatpackcomposetest.domain

data class InteractionsItem(
    val type: InteractionsType,
    val count: Int = 0
)

enum class InteractionsType {
    VIEWS, COMMENTS, SHARES, LIKES
}