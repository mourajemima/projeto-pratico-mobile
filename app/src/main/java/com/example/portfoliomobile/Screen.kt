package com.example.portfoliomobile

sealed class Screen(val route: String) {
    object Profile: Screen("profile")
    object ProjectList: Screen("project_list")
    object ProjectDetail: Screen("project_detail/{projectId}")
}