package com.example.portfoliomobile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProjectViewModelFactory(
    private val repository: ProjectRepository,
    private val githubUser: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProjectViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProjectViewModel(repository, githubUser) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
