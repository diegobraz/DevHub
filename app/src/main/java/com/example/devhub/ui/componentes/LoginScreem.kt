package com.example.devhub.ui.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import com.example.devhub.ui.Screen

@Composable
fun LoginScreem(navController: NavHostController ? = null) {
    val text = remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(all = 8.dp),
        verticalArrangement = Arrangement.Center

    ) {
        Text("DevHub", style = TextStyle(fontSize = 30.sp))
        TextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            label = { Text("Usuario") },
            modifier = Modifier.padding(top = 20.dp)
        )
        Button(
            onClick = { onEnterClick(text.value, navController) },
            Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
                .fillMaxWidth()
        ) {
            Text(text = "Entrar")
        }
    }
}

fun onEnterClick(text: String, navController: NavHostController?) {
    navController?.navigate(route =Screen.home.passUser(text))
}

@Composable
@Preview(showBackground = true)
fun PreviewLoginScreem() {
    LoginScreem()
}