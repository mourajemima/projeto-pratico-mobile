package com.example.portfoliomobile

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "projects")
data class ProjectEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String?,
    val language: String?
)
