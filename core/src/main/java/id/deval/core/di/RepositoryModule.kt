package id.deval.core.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.deval.core.data.FavoriteGameRepository
import id.deval.core.data.GameRepository
import id.deval.core.domain.repository.IFavoriteGameRepository
import id.deval.core.domain.repository.IGameRepository

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(gameRepository: GameRepository): IGameRepository

    @Binds
    abstract fun provideFavoriteGameRepository(favoriteGameRepository: FavoriteGameRepository) : IFavoriteGameRepository
}