package cl.bootcamp.sprintfinalm6.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface MovilDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movils: Movils)

    @Query("SELECT * FROM movils")
    fun getAllMovils(): Flow<List<Movils>>
}