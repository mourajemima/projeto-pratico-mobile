package com.example.portfoliomobile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

val sampleProject = listOf(
    Project(1, "App Portfólio", "App desenvolvido durante a disciplina de programação", "Kotlin" ),
    Project(2, "API da Pizzaria", "Back-end de uma pizzaria", "Node.js" ),
    Project(3, "Conversor de moedas", "Conversor de moedas simples", "Java" ),
    Project(4, "API de livros", "Back-end com consumo de API externa", "Java" ),
    Project(5, "To-list", "Aplicação web para listar tarefas", "Node.js + React" )
)

@Composable
fun ProjectCard(project: Project, navController: NavController) {
    Column (
        modifier = Modifier.padding(16.dp)
    ) {
        Card(
            modifier = Modifier.clickable {
                navController.navigate("project_detail/${project.id}")
            }
        ) {
            Text(text = project.name, fontWeight = FontWeight.Bold)
            Text(text = project.description, color = Color.Gray)
            Text(text = "Tecnologia: ${project.language}", color = Color.DarkGray)
        }
    }
}

@Composable
fun ProjectListScreen(navController: NavController) {
    LazyColumn {
        items(
            items = sampleProject,
            key = { project -> project.id }
        ) { project ->
            ProjectCard(project = project, navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectListScreenPreview() {
    val navController = rememberNavController()
    ProjectListScreen(navController)
}