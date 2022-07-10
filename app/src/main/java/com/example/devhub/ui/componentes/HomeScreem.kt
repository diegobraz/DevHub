package com.example.devhub.ui.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.devhub.ui.MainViewModel

@Composable
fun HomeScreem(user: String? = null, mainViewModel: MainViewModel) {
    if (user != null) {
        mainViewModel.getUser(user)
        mainViewModel.getAllRepositories(user)
    }
    val allRepositories by mainViewModel.allrepositories.observeAsState()
    val userProfile by mainViewModel.userResponse.observeAsState()
    Column {
        LazyColumn {
            item {
                userProfile?.let { user ->
                    LoadProfileInformation(user)
                }
            }
            items(allRepositories?.toList() ?: emptyList()) { repositoriesItem ->
                RepositoryItem(repositoriesItem)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreemPreview() {
    HomeScreem("diegobraz",mainViewModel = viewModel())
}