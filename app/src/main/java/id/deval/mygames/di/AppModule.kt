package id.deval.mygames.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import id.deval.core.domain.usecase.FavoriteGameInteractor
import id.deval.core.domain.usecase.FavoriteGameUsecase
import id.deval.core.domain.usecase.GameInteractor
import id.deval.core.domain.usecase.GameUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideGameUseCase(gameInteractor: GameInteractor): GameUseCase

    @Binds
    @Singleton
    abstract fun provideFavoriteGameUseCase(favoriteGameInteractor: FavoriteGameInteractor) : FavoriteGameUsecase
}