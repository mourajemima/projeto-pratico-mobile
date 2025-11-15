package com.example.portfoliomobile

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    val db = AppDatabase.getInstance(context)
    val dao = db.projectDao()
    val api = RetrofitInstance.api
    val repository = ProjectRepository(dao, api)

    val githubUser = "mourajemima"

    val vmFactory = ProjectViewModelFactory(repository, githubUser)
    val viewModel: ProjectViewModel = viewModel(factory = vmFactory)

    NavHost(
        navController = navController,
        startDestination = Screen.Profile.route
    ) {
        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }

        composable(route = Screen.ProjectList.route) {
            ProjectListScreen(navController = navController, viewModel = viewModel)
        }

        composable(
            route = Screen.ProjectDetail.route,
            arguments = listOf(
                navArgument("projectId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val projectId = backStackEntry.arguments?.getInt("projectId")
            if (projectId != null) {
                ProjectDetailScreen(projectId = projectId, navController = navController, viewModel = viewModel)
            }
        }
    }
}
