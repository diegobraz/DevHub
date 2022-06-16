package com.example.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.devhub.ui.theme.DevHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoadInformation()
                }
            }
        }
    }

    @Composable
    fun LoadInformation() {
        Column {
            Image(
                painter = painterResource(R.drawable.photo_profile),
                contentDescription = getString(R.string.profile_photo),
                modifier = Modifier
                    .padding(all = 4.dp)
                    .size(width = 250.dp, height = 250.dp)
            )
            SetText("Diego Braz")
            SetText("diegobraz")
            SetText("Android Developer")
        }
    }

    @Composable
    private fun SetText(title: String) {
        Text(
            title,
            color = Color.Black,
            modifier = Modifier.padding(start = 8.dp),
            style = TextStyle(fontSize = 20.sp)
        )
    }
}