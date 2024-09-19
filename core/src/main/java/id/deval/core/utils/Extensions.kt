package id.deval.core.utils

import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import id.deval.core.data.source.local.entity.AddedByStatusEntity
import id.deval.core.data.source.local.entity.EsrbRatingEntity
import id.deval.core.data.source.local.entity.MetacriticPlatformsItemEntity
import id.deval.core.data.source.local.entity.PlatformEntity
import id.deval.core.data.source.local.entity.PlatformsItemEntity
import id.deval.core.data.source.local.entity.RatingsEntity
import id.deval.core.data.source.local.entity.ReactionsEntity
import id.deval.core.data.source.local.entity.RequirementsEntity
import id.deval.core.data.source.remote.response.AddedByStatusResponse
import id.deval.core.data.source.remote.response.EsrbRatingResponse
import id.deval.core.data.source.remote.response.MetacriticPlatformsItemResponse
import id.deval.core.data.source.remote.response.PlatformResponse
import id.deval.core.data.source.remote.response.PlatformsItemResponse
import id.deval.core.data.source.remote.response.RatingsResponse
import id.deval.core.data.source.remote.response.ReactionsResponse
import id.deval.core.data.source.remote.response.RequirementsResponse
import id.deval.core.domain.model.AddedByStatus
import id.deval.core.domain.model.EsrbRating
import id.deval.core.domain.model.MetacriticPlatformsItem
import id.deval.core.domain.model.Platform
import id.deval.core.domain.model.PlatformsItem
import id.deval.core.domain.model.Ratings
import id.deval.core.domain.model.Reactions
import id.deval.core.domain.model.Requirements


fun NavController.safeNavigation(
    @IdRes id : Int,
    args : Bundle? = null,
    navOptions: NavOptions? = null
) {
    try {
        navigate(id, args, navOptions)
    } catch (e : Throwable){
        Log.d("safeNavigationFailed", "safeNavigation: $e")
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
