package com.example.portfoliomobile

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Profile.route
    ) {
        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }

        composable(route = Screen.ProjectList.route) {
            ProjectListScreen(navController = navController)
        }
        composable(
            route = Screen.ProjectDetail.route,
            arguments = listOf(
                navArgument("projectId")
                { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val projectId = backStackEntry.arguments?.getInt("projectId")
            if (projectId != null) {
                ProjectDetailScreen(projectId = projectId)
            }
        }
    }
}