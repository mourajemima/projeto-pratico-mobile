package com.example.portfoliomobile

import com.google.gson.annotations.SerializedName

data class ProjectDto(
    val id: Int,
    val name: String,
    val description: String?,
    val language: String?
) {
    fun toEntity() = ProjectEntity(
        id = id,
        name = name,
        description = description,
        language = language
    )

    fun toDomainModel() = Project(
        id = id,
        name = name,
        description = description ?: "",
        language = language ?: ""
    )
}
