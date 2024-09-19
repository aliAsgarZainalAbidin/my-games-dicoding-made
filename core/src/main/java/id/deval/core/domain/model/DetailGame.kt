package id.deval.core.domain.model

import androidx.room.ColumnInfo

data class DetailGame(
    val added: Int? = null,

    val nameOriginal: String? = null,

    val metacritic: Int? = null,

    val rating: Int? = null,

    val description: String? = null,

    val gameSeriesCount: Int? = null,

    val playtime: Int? = null,

    val metacriticUrl: String? = null,

    val alternativeNames: List<String?>? = null,

    val parentsCount: Int? = null,

    val platforms: List<PlatformsItem?>? = null,

    val metacriticPlatforms: List<MetacriticPlatformsItem?>? = null,

    val creatorsCount: Int? = null,

    val ratingTop: Int? = null,

    val reviewsTextCount: String? = null,

    val ratings: Ratings? = null,

    val achievementsCount: Int? = null,

    val id: Int? = null,

    val addedByStatus: AddedByStatus?
    = null,
    val redditUrl: String? = null,

    val redditName: String? = null,

    val ratingsCount: Int? = null,

    val redditCount: Int? = null,

    val slug: String? = null,

    val released: String? = null,

    val parentAchievementsCount: String? = null,

    val website: String? = null,

    val suggestionsCount: Int? = null,

    val youtubeCount: String? = null,

    val additionsCount: Int? = null,

    val moviesCount: Int? = null,

    val twitchCount: String? = null,

    val backgroundImageAdditional: String? = null,

    val backgroundImage: String? = null,

    val tba: Boolean? = null,

    val esrbRating: EsrbRating? = null,

    val screenshotsCount: Int? = null,

    val name: String? = null,

    val redditDescription: String? = null,

    val reactions: Reactions? = null,

    val redditLogo: String? = null,

    val updated: String? = null,
)


data class MetacriticPlatformsItem(
    val metascore: Int? = null,

    val url: String? = null,
)


data class Reactions(
    val any: Any? = null,
)