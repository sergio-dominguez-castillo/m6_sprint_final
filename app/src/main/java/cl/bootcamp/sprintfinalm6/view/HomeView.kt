package cl.bootcamp.sprintfinalm6.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import cl.bootcamp.sprintfinalm6.R
import cl.bootcamp.sprintfinalm6.components.CardComponent
import cl.bootcamp.sprintfinalm6.components.TopBarComponent
import cl.bootcamp.sprintfinalm6.viewModel.MovilViewModel

@Composable
fun HomeView(movilViewModel: MovilViewModel, navController: NavController) {

    Scaffold(
        topBar = {
            TopBarComponent(
                title = stringResource(R.string.app_name)
            ) { }
        }
    ) { innerPadding ->
        val movil by movilViewModel.movils.collectAsState(listOf())

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            items(movil) { item ->
                CardComponent(
                    item.name,
                    item.price,
                    item.image
                ) {
                    navController.navigate("Details/${item.id}")
                }
            }
        }
    }

}