package cl.bootcamp.sprintfinalm6.di

import cl.bootcamp.sprintfinalm6.repository.MovilsRepository
import cl.bootcamp.sprintfinalm6.repository.MovilsRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun movilsRepository(movilsRepositoryImp: MovilsRepositoryImp): MovilsRepository
}