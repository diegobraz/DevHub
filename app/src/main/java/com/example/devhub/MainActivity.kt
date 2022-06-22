package com.example.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.devhub.ui.MainViewModel
import com.example.devhub.ui.theme.DevHubTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    mainViewModel.getUser("diegobraz")
                    LoadInformation(mainViewModel)
                }
            }
        }
    }

    @Composable
    fun LoadInformation(user: MainViewModel) {
        val  responseUserState by user.userResponse.observeAsState()
        Box {
            Box(Modifier.fillMaxWidth().background(Color.Gray).height(150.dp))
            Column(
                modifier = Modifier.fillMaxWidth().align(alignment = Alignment.TopCenter)
                    .padding(top = 75.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = responseUserState?.avatar_url,
                    contentDescription = getString(R.string.profile_photo),
                    modifier = Modifier
                        .padding(all = 4.dp)
                        .size(width = 150.dp, height = 150.dp)
                        .clip(CircleShape)
                )
                SetText(
                    responseUserState?.name ?:"teste" ,
                    textStyle = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
                )
                SetText(
                    responseUserState?.login ?:"teste" ,
                    textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                )
                SetText(
                    responseUserState?.bio ?:"teste" ,
                    textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Normal)
                )
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