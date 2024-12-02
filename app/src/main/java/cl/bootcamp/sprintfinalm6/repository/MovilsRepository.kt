package cl.bootcamp.sprintfinalm6.repository

import cl.bootcamp.sprintfinalm6.datasource.RestDataSource
import cl.bootcamp.sprintfinalm6.model.Movil
import cl.bootcamp.sprintfinalm6.model.MovilDao
import cl.bootcamp.sprintfinalm6.model.MovilID
import cl.bootcamp.sprintfinalm6.model.Movils
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface MovilsRepository {
    suspend fun getMovilById(id: Int): MovilID
    suspend fun getAllMovil(): ArrayList<Movil>
    fun getAllMovils(): Flow<List<Movils>>
}

class MovilsRepositoryImp @Inject constructor(
    private val dataSource: RestDataSource,
    private val movilDao: MovilDao

) : MovilsRepository {
    override suspend fun getMovilById(id: Int): MovilID {
        val datos = dataSource.getMovilById(id).body()!!
        val movil = MovilID(
            datos.id,
            datos.name,
            datos.price,
            datos.image,
            datos.description,
            datos.lastPrice,
            datos.credit

        )
        return movil
    }


    override suspend fun getAllMovil(): ArrayList<Movil> {
        val datos = dataSource.getMovil()
        datos.forEach {
            val movil = Movils(
                it.id,
                it.name,
                it.price,
                it.image
                )
            movilDao.insert(movil)
        }
        return ArrayList(datos)
    }


    override fun getAllMovils(): Flow<List<Movils>> = movilDao.getAllMovils()

}