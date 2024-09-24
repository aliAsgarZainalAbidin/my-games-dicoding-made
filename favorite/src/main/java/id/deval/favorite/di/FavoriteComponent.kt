package id.deval.favorite.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import id.deval.mygames.di.FavoriteModuleDependencies
import id.deval.favorite.ui.FavoriteFragment

@Component(
    dependencies = [FavoriteModuleDependencies::class]
)
interface FavoriteComponent {
    fun inject(favoriteFragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context) : Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies) : Builder
        fun build() : FavoriteComponent
    }

}