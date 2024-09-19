package id.deval.mygames.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.deval.core.domain.usecase.GameInteractor
import id.deval.core.domain.usecase.GameUseCase

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideGameUseCase(gameInteractor: GameInteractor): GameUseCase
}