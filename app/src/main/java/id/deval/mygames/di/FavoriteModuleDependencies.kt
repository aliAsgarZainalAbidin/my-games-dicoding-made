package id.deval.mygames.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.deval.core.domain.usecase.FavoriteGameUsecase

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun favoriteUsecase() : FavoriteGameUsecase
}