package com.example.testwebservice.Model
import java.io.Serializable
data class Cat (
        val id: Long,
    val nomCat: String,
        val photo: String,
    val description: String
): Serializable
