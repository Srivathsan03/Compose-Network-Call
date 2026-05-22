package com.sri.testnetworkcall.ui.screens.home.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.sri.testnetworkcall.ui.navigation.Screen
import com.sri.testnetworkcall.ui.screens.home.model.UsersResp
import com.sri.testnetworkcall.ui.screens.home.model.UsersRespItem
import com.sri.testnetworkcall.ui.screens.home.model.UsersUiState
import com.sri.testnetworkcall.ui.screens.home.viewmodel.UsersListViewModel
import com.sri.testnetworkcall.utils.Constants

@Composable
fun UsersListScreen(
    navController: NavHostController,
    viewModel: UsersListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    UsersListContent(
        navController = navController,
        uiState = uiState
    )
}

@Composable
fun UsersListContent(
    navController: NavHostController,
    uiState: UsersUiState
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when (val state = uiState) {
                is UsersUiState.Loading -> {
                    CircularProgressIndicator()
                }

                is UsersUiState.Success -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(state.users) { user ->
                            UserItem(
                                user = user,
                                onClick = {
                                    navController.currentBackStackEntry?.savedStateHandle?.set(
                                        Constants.KEY_USER,
                                        user
                                    )
                                    navController.navigate(Screen.Details.route)
                                }
                            )
                        }
                    }
                }

                is UsersUiState.Error -> {
                    Text(
                        text = "Error: ${state.message}",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}

@Composable
fun UserItem(
    user: UsersRespItem,
    onClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(user.photo)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = user.name ?: "Unknown",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "ID: ${user.id}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview_UsersList() {
    val fakeUsers = UsersResp().apply {
        add(UsersRespItem(id = 1, name = "John Doe"))
        add(UsersRespItem(id = 2, name = "Jane Smith"))
    }
    UsersListContent(
        navController = rememberNavController(),
        uiState = UsersUiState.Success(fakeUsers)
    )
}
