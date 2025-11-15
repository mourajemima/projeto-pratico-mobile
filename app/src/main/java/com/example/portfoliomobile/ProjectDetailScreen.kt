package com.example.portfoliomobile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProjectDetailScreen(
    projectId: Int,
    navController: NavController,
    viewModel: ProjectViewModel
) {
    val projects by viewModel.projects.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    val project = projects.find { it.id == projectId }

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(top = 40.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            project != null -> {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = project.name,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = project.description,
                            fontSize = 16.sp,
                            color = Color.DarkGray
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Tecnologia: ${project.language}",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

            else -> {
                Text(
                    text = "Projeto não encontrado",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Screen.ProjectList.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(text = "Lista de Projetos")
        }
    }
}
