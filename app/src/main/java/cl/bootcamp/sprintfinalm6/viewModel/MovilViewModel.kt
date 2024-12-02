package cl.bootcamp.sprintfinalm6.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.bootcamp.sprintfinalm6.model.MovilState
import cl.bootcamp.sprintfinalm6.model.Movils
import cl.bootcamp.sprintfinalm6.repository.MovilsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovilViewModel @Inject constructor(
    private val repo: MovilsRepository
) : ViewModel() {
    var state by mutableStateOf(MovilState())
        private set

    val movils: Flow<List<Movils>> by lazy {
        repo.getAllMovils()
    }

    init {
        getAllAPI()
    }

    private fun getAllAPI() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllMovil()
        }
    }

    fun getMovilById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val datos = repo.getMovilById(id)
            state = state.copy(
                name = datos.name,
                price = datos.price,
                image = datos.image,
                description = datos.description,
                lastPrice = datos.lastPrice,
                credit = datos.credit
            )
        }
    }

    fun cleanState() {
        state = state.copy(
            name = "",
            price = 0.0,
            image = "",
            description = "",
            lastPrice = 0.0,
            credit = false
        )
    }


}