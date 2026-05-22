package com.sri.testnetworkcall.ui.screens.detail.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.size.Size
import com.sri.testnetworkcall.ui.screens.detail.viewmodel.DetailsViewModel
import com.sri.testnetworkcall.ui.screens.home.model.UsersRespItem
import com.sri.testnetworkcall.utils.Constants

@Composable
fun DetailsScreen(
    navController: NavHostController,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val user =
        navController.previousBackStackEntry?.savedStateHandle?.get<UsersRespItem>(Constants.KEY_USER)
    DetailsScreenContent(user = user)
}

@Composable
fun DetailsScreenContent(
    user: UsersRespItem?
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(user?.photo)
                    .size(Size.ORIGINAL)
                    .build(),
                contentDescription = null
            )
            Text(text = "ID = ${user?.id}")
            Text(text = "Name = ${user?.name}")
            Text(text = "Address = ${user?.address}")
            Text(text = "State = ${user?.state}")
            Text(text = "Country = ${user?.country}")
            Text(text = "Zip = ${user?.zip}")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview_DetailsScreenContent() {
    val fakeUser = UsersRespItem(
        photo = "",
        id = 1,
        name = "Srivathsan"
    )
    DetailsScreenContent(fakeUser)
}