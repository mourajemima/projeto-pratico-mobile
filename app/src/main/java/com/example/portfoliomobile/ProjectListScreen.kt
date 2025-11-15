package com.example.portfoliomobile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProjectCard(project: Project, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate("project_detail/${project.id}")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = project.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = project.description,
                fontSize = 16.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Tecnologia: ${project.language}",
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun ProjectListScreen(navController: NavController, viewModel: ProjectViewModel) {
    val projects by viewModel.projects.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    androidx.compose.runtime.LaunchedEffect(Unit) {
        viewModel.refresh()
    }

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(top = 40.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Meus Projetos",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(
                items = projects,
                key = { project -> project.id }
            ) { project ->
                ProjectCard(project = project, navController = navController)
            }
        }

        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate(Screen.Profile.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(text = "Perfil")
        }
        Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))
    }
}

