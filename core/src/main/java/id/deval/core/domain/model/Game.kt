package id.deval.core.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity


data class Game(
    val added: Int? = null,

    val suggestionsCount: Int? = null,

    val rating: Int? = null,

    val metacritic: Int? = null,

    val playtime: Int? = null,

    val platforms: List<PlatformsItem?>? = null,

    val backgroundImage: String? = null,

    val tba: Boolean? = null,

    val esrbRating: EsrbRating? = null,

    val ratingTop: Int? = null,

    val reviewsTextCount: String? = null,

    val name: String? = null,

    val id: Int? = null,

    val ratingsCount: Int? = null,

    val updated: String? = null,

    val slug: String? = null,

    val released: String? = null
)

data class PlatformsItem(
    val requirements: Requirements? = null,

    val releasedAt: String? = null,

    val platform: Platform? = null
)

data class Platform(
    val name: String? = null,

    val id: Int? = null,

    val slug: String? = null
)

data class EsrbRating(
    val name: String? = null,

    val id: Int? = null,

    val slug: String? = null
)

data class Requirements(
    val minimum: String? = null,

    val recommended: String? = null
)

data class AddedByStatus(
    //TODO(check object attributes api.rawg.io)
    val any: String? = null
)

data class Ratings(
    //TODO(check object attributes api.rawg.io)
    val any: String? = null
)