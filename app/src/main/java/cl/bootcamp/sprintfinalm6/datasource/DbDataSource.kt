package cl.bootcamp.sprintfinalm6.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.sprintfinalm6.model.MovilDao
import cl.bootcamp.sprintfinalm6.model.Movils

@Database(entities = [Movils::class], version = 1)
abstract class DbDataSource: RoomDatabase() {
    abstract fun movilDao(): MovilDao
}