package cl.bootcamp.sprintfinalm6.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.sprintfinalm6.view.DetailsView
import cl.bootcamp.sprintfinalm6.view.HomeView
import cl.bootcamp.sprintfinalm6.viewModel.MovilViewModel

@Composable
fun NavManager(movilViewModel: MovilViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(movilViewModel, navController)
        }
        composable("Details/{id}", arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )) {
            val id = it.arguments?.getInt("id") ?: 0
            DetailsView(movilViewModel, navController, id)
        }
    }
}