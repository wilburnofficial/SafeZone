package com.example.safezone.data.models

import androidx.annotation.Keep

@Keep
data class Recipe(
    //Unique ID for database entry
    val id: String = "",

    //Core recipe details
    val name: String = "",
    val description: String = "",

    //Galactosemia specific content
    val galactoseContent: Float = 0.0f,

    //Data structures for ingredients and instructions
    val ingredients: List<String> = emptyList(),
    val instructions: String = "",

    //References to other services
    val imageUrl: String = "", //URL from Firebase Storage
    val userId: String = "" //ID of the user who uploaded the recipe
)