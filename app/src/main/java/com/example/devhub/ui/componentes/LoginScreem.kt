package com.example.devhub.ui.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.devhub.ui.Screen

@Composable
fun LoginScreem(navController: NavHostController ? = null) {
    val text = remember { mutableStateOf("") }
    val isError = rememberSaveable{ mutableStateOf(false)}
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
            onValueChange = { name ->
                text.value = name
                isError.value = false
            },
            label = { Text("Usuario") },
            modifier = Modifier.padding(top = 20.dp),
            isError = isError.value,
            trailingIcon = {
                if (isError.value){
                    Icon(
                        Icons.Filled.Error, "error",
                        tint = MaterialTheme.colors.error
                    )
                }
            },
        )
        if (isError.value){
            Text(
                text = "Error message",
                color = MaterialTheme.colors.error,
                style = TextStyle(fontSize = 12.sp),
                modifier = Modifier.padding(start = 50.dp)
                    .fillMaxWidth()
            )
        }
        Button(
            onClick = {
                if (text.value.isNotEmpty()) onEnterClick(text.value, navController)
            else isError.value = true},
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
    navController?.navigate(route =Screen.Home.passUser(text))
}

@Composable
@Preview(showBackground = true)
fun PreviewLoginScreem() {
    LoginScreem()
}