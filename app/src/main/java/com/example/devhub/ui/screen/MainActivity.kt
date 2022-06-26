package com.example.devhub.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.devhub.ui.MainViewModel
import com.example.devhub.ui.componentes.LoadProfileInformation
import com.example.devhub.ui.componentes.RepositoryItem
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
                    mainViewModel.getAllRepositories("diegobraz")
                    val allrepositorie by mainViewModel.allrepositories.observeAsState()
                    Column {
                        LoadProfileInformation(mainViewModel.userResponse)
                        LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
                            items(allrepositorie?.toList() ?: emptyList()){ repositoriesItem ->
                                   RepositoryItem(repositoriesItem)
                            }
                        }
                    }
                }
            }
        }
    }
}
