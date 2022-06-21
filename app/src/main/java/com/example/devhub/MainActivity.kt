package com.example.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
        Box{
            Box(Modifier.fillMaxWidth().background(Color.Gray).height(150.dp))
            Column(modifier = Modifier.fillMaxWidth().align(alignment = Alignment.TopCenter).padding(top = 75.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.photo_profile),
                    contentDescription = getString(R.string.profile_photo),
                    modifier = Modifier
                        .padding(all = 4.dp)
                        .size(width = 150.dp, height = 150.dp)
                        .clip(CircleShape)
                )
                SetText(
                    "Diego Braz",
                    textStyle = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
                )
                SetText("diegobraz", textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
                SetText("Android Developer",textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Normal))
            }
        }
    }

    @Composable
    private fun SetText(title: String, textStyle: TextStyle? = null, ) {
        Text(
            title,
            color = Color.Black,
            modifier = Modifier.padding(start = 8.dp),
            style = textStyle ?: TextStyle(fontSize = 20.sp)
        )
    }
}