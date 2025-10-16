package com.example.portfoliomobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(top = 40.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
    ) {
        UserSection()
        Spacer(
            modifier = Modifier
                .width(10.dp)
        )
        InformationSection(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileSectionPreview() {
    val navController = androidx.navigation.compose.rememberNavController()
    ProfileScreen(navController)
}


@Composable
fun UserSection() {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(20.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.perfile_image),
            contentDescription = "Jemima sorrindo e ao fundo uma escada com luzes",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = "Jemima Moura",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .paddingFromBaseline(top = 30.dp)
        )
        Text(
            text = "Tecnóloga em Sistemas para Internet",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .paddingFromBaseline(top = 18.dp)
        )
    }
}

@Composable
fun InformationSection(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(20.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 5.dp)
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.telefone),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
            Text(
                text = "84 99999-9999",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 5.dp)
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.email),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
            Text(
                text = "jemimahelen@hotmail.com",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 5.dp)
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.linkedin),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
            Text(
                text = "linkedin.com/in/jemima-moura",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 5.dp)
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.github),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
            Text(
                text = "github.com/mourajemima",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }
        Button(
            onClick = {
                navController.navigate(Screen.ProjectList.route)
            }
        ) {
            Text(
                text = "Projetos"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserSectionPreview() {
    UserSection()
}

@Preview(showBackground = true)
@Composable
fun InformationSectionPreview() {
    val navController = androidx.navigation.compose.rememberNavController()
    InformationSection(navController)
}