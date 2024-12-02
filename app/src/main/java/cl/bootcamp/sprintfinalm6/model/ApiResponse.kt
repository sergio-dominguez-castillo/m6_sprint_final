package cl.bootcamp.sprintfinalm6.model

data class ApiResponse(val data: ArrayList<Movil>)

data class Movil(
    val id: Int,
    val name: String,
    val price: Double,
    val image: String
)

data class MovilID(
    val id: Int,
    val name: String,
    val price: Double,
    val image: String,
    val description: String,
    val lastPrice: Double,
    val credit: Boolean
)