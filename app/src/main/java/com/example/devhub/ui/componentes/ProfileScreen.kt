package com.example.devhub.ui.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import coil.compose.AsyncImage
import com.example.devhub.R
import com.example.devhub.model.User


@Composable
fun LoadProfileInformation(user: LiveData<User>) {
    val responseUserState by user.observeAsState()
    Box {
        Box(Modifier.fillMaxWidth().background(Color.Gray).height(150.dp))
        Column(
            modifier = Modifier.fillMaxWidth().align(alignment = Alignment.TopCenter)
                .padding(top = 75.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = responseUserState?.avatar_url,
                contentDescription = stringResource(R.string.profile_photo),
                modifier = Modifier
                    .padding(all = 4.dp)
                    .size(width = 150.dp, height = 150.dp)
                    .clip(CircleShape)
            )
            SetText(
                responseUserState?.name ?: "teste",
                textStyle = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )
            SetText(
                responseUserState?.login ?: "teste",
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )
            SetText(
                responseUserState?.bio ?: "teste",
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
private fun SetText(title: String, textStyle: TextStyle? = null) {
    Text(
        title,
        color = Color.Black,
        modifier = Modifier.padding(start = 8.dp),
        style = textStyle ?: TextStyle(fontSize = 20.sp)
    )
}