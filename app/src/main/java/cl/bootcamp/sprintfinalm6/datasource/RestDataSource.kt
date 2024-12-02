package cl.bootcamp.sprintfinalm6.datasource

import cl.bootcamp.sprintfinalm6.model.Movil
import cl.bootcamp.sprintfinalm6.model.MovilID
import cl.bootcamp.sprintfinalm6.util.Constants.Companion.ENDPOINT
import cl.bootcamp.sprintfinalm6.util.Constants.Companion.ENDPOINTD
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestDataSource {
    @GET(ENDPOINT)
    suspend fun getMovil(): List<Movil>

    @GET("$ENDPOINTD/{id}")
    suspend fun getMovilById(@Path(value = "id") id: Int): Response<MovilID>

}