package com.example.test

import java.io.Serializable

data class StudentModel(
    val name: String,
    val id: String
) : Serializable {
    override fun toString(): String = "$name - $id"
}
