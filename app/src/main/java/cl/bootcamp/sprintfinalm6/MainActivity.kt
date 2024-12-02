package cl.bootcamp.sprintfinalm6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import cl.bootcamp.sprintfinalm6.navigation.NavManager
import cl.bootcamp.sprintfinalm6.ui.theme.SprintFinalM6Theme
import cl.bootcamp.sprintfinalm6.viewModel.MovilViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        val movilViewModel: MovilViewModel by viewModels()
        setContent {
            SprintFinalM6Theme {
                NavManager(movilViewModel)
            }
        }
    }
}
