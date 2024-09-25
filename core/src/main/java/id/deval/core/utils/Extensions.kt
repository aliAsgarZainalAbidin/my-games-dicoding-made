package id.deval.core.utils

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.annotation.IdRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import id.deval.core.data.source.local.entity.AddedByStatusEntity
import id.deval.core.data.source.local.entity.EsrbRatingEntity
import id.deval.core.data.source.local.entity.FavoriteGameEntity
import id.deval.core.data.source.local.entity.GenreEntity
import id.deval.core.data.source.local.entity.MetacriticPlatformsItemEntity
import id.deval.core.data.source.local.entity.PlatformEntity
import id.deval.core.data.source.local.entity.PlatformsItemEntity
import id.deval.core.data.source.local.entity.RatingsEntity
import id.deval.core.data.source.local.entity.ReactionsEntity
import id.deval.core.data.source.local.entity.RequirementsEntity
import id.deval.core.data.source.local.entity.ShortScreenshotsEntity
import id.deval.core.data.source.remote.response.AddedByStatusResponse
import id.deval.core.data.source.remote.response.EsrbRatingResponse
import id.deval.core.data.source.remote.response.GenreResponse
import id.deval.core.data.source.remote.response.MetacriticPlatformsItemResponse
import id.deval.core.data.source.remote.response.PlatformResponse
import id.deval.core.data.source.remote.response.PlatformsItemResponse
import id.deval.core.data.source.remote.response.RatingsResponse
import id.deval.core.data.source.remote.response.ReactionsResponse
import id.deval.core.data.source.remote.response.RequirementsResponse
import id.deval.core.data.source.remote.response.ShortScreenshotsResponse
import id.deval.core.domain.model.AddedByStatus
import id.deval.core.domain.model.EsrbRating
import id.deval.core.domain.model.FavoriteGame
import id.deval.core.domain.model.Game
import id.deval.core.domain.model.Genre
import id.deval.core.domain.model.MetacriticPlatformsItem
import id.deval.core.domain.model.Platform
import id.deval.core.domain.model.PlatformsItem
import id.deval.core.domain.model.Ratings
import id.deval.core.domain.model.Reactions
import id.deval.core.domain.model.Requirements
import id.deval.core.domain.model.ShortScreenshots
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.cancellation.CancellationException


fun NavController.safeNavigation(
    @IdRes id : Int,
    args : Bundle? = null,
    navOptions: NavOptions? = null
) {
    try {
        navigate(id, args, navOptions)
    } catch (e : Throwable){
        Log.d("safeNavigationFailed", "safeNavigation: Graph ${this.graph} Error -> $e")
    }
}

fun NavController.safeNavigation(
    deepLink : NavDeepLinkRequest
) {
    try {
        navigate(deepLink)
    } catch (e : Throwable){
        Log.d("safeNavigationFailed", "safeNavigation: Deeplink $e")
    }
}


fun CoroutineScope.launchCatchError(
    context: CoroutineContext = coroutineContext,
    block: suspend CoroutineScope.() -> Unit,
    onError: suspend (Throwable) -> Unit
) =
    launch(context) {
        try {
            block()
        } catch (t: Throwable) {
            if (t is CancellationException) throw t
            else {
                try {
                    onError(t)
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }
        }
    }

fun CoroutineScope.launchCatchError(
    block: suspend CoroutineScope.() -> Unit,
    onError: suspend (Throwable) -> Unit
) =
    launch {
        try {
            block()
        } catch (t: Throwable) {
            if (t is CancellationException) throw t
            else {
                try {
                    onError(t)
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }
        }
    }

fun Handler.safePostDelayed(runnable: Runnable, delay: Long) {
    postDelayed({
        try {
            runnable.run()
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }, delay)
}

fun <T> LiveData<T>.nonNullObserve(owner: LifecycleOwner, observe: (t: T) -> Unit) {
    this.observe(owner) {
        it?.let(observe)
    }
}


fun <T> ActivityResultLauncher<T>.safeLaunch(input : T){
    try {
        this.launch(input)
    } catch (e:Exception){
        e.printStackTrace()
    }
}

fun PlatformsItemResponse.toEntity() = PlatformsItemEntity(
    requirements = requirements?.toEntity(),
    releasedAt = releasedAt,
    platform = platform?.toEntity()
)

fun RequirementsResponse.toEntity() = RequirementsEntity(
    minimum = minimum,
    recommended = recommended
)

fun PlatformResponse.toEntity() = PlatformEntity(
    name = name,
    id = id,
    slug = slug
)

fun MetacriticPlatformsItemResponse.toEntity() = MetacriticPlatformsItemEntity(
    metascore = metascore,
    url = url
)

fun RatingsResponse.toEntity() = RatingsEntity(
    any = any
)

fun AddedByStatusResponse.toEntity() = AddedByStatusEntity(
    any = any
)

fun EsrbRatingResponse.toEntity() = EsrbRatingEntity(
    name = name,
    id = id,
    slug = slug
)

fun ReactionsResponse.toEntity() = ReactionsEntity(
    any = any
)

fun PlatformsItemEntity.toDomain() = PlatformsItem(
    requirements = requirements?.toDomain(),
    releasedAt = releasedAt,
    platform = platform?.toDomain()
)

fun RequirementsEntity.toDomain() = Requirements(
    minimum = minimum,
    recommended = recommended
)

fun PlatformEntity.toDomain() = Platform(
    name = name,
    id = id,
    slug = slug
)

fun RatingsEntity.toDomain() = Ratings(
    any = any
)

fun AddedByStatusEntity.toDomain() = AddedByStatus(
    any = any
)

fun EsrbRatingEntity.toDomain() = EsrbRating(
    name = name,
    id = id,
    slug = slug
)

fun ReactionsEntity.toDomain() = Reactions(
    any = any
)

fun MetacriticPlatformsItemEntity.toDomain() = MetacriticPlatformsItem(
    metascore = metascore,
    url = url
)

fun GenreResponse.toEntity() = GenreEntity(
    name = name,
    id = id,
    slug = slug
)

fun GenreEntity.toDomain() = Genre(
    name = name,
    id = id,
    slug = slug
)

fun Genre.toEntity() = GenreEntity(
    name = name,
    id = id,
    slug = slug
)

fun PlatformsItem.toEntity() = PlatformsItemEntity(
    requirements = requirements?.toEntity(),
    releasedAt = releasedAt,
    platform = platform?.toEntity()
)

fun Requirements.toEntity() = RequirementsEntity(
    minimum = minimum,
    recommended = recommended
)

fun Platform.toEntity() = PlatformEntity(
    name = name,
    id = id,
    slug = slug
)

fun ShortScreenshotsResponse.toEntity() = ShortScreenshotsEntity(
    id = id,
    image = image
)

fun ShortScreenshotsEntity.toDomain() = ShortScreenshots(
    id = id,
    image = image
)

fun ShortScreenshots.toEntity() = ShortScreenshotsEntity(
    id = id,
    image = image
)

fun EsrbRating.toEntity() = EsrbRatingEntity(
    name = name,
    id = id,
    slug = slug
)

fun FavoriteGame.toGame() = Game(
    id = id,
    name = name,
    released = released,
    backgroundImage = backgroundImage,
    rating = rating,
    genre = genre,
    platforms = platforms,
    shortScreenshots = shortScreenshots,
    esrbRating = esrbRating,
    suggestionsCount = suggestionsCount,
    added = added,
    metacritic = metacritic,
    playtime = playtime,
    tba = tba,
    ratingsCount = ratingsCount,
    updated = updated,
    slug = slug,
    isFavorite = true,
)

fun Game.toFavoriteGameEntity() = FavoriteGameEntity(
    id = id,
    name = name,
    released = released,
    backgroundImage = backgroundImage,
    rating = rating,
    genre = genre?.map { it.toEntity() },
    platforms = platforms?.map { it?.toEntity() },
    shortScreenshots = shortScreenshots?.map { it.toEntity() },
    esrbRating = esrbRating?.toEntity(),
    suggestionsCount = suggestionsCount,
    added = added,
    metacritic = metacritic,
    playtime = playtime,
    tba = tba,
    ratingsCount = ratingsCount,
    updated = updated,
    slug = slug,
)