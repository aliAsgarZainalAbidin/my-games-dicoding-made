package id.deval.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail_game")
data class DetailGameEntity(
	@ColumnInfo("added")
	val added: Int? = null,

	@ColumnInfo("nameOriginal")
	val nameOriginal: String? = null,

	@ColumnInfo("metacritic")
	val metacritic: Int? = null,

	@ColumnInfo("rating")
	val rating: Int? = null,

	@ColumnInfo("description")
	val description: String? = null,

	@ColumnInfo("gameSeriesCount")
	val gameSeriesCount: Int? = null,

	@ColumnInfo("playtime")
	val playtime: Int? = null,

	@ColumnInfo("metacriticUrl")
	val metacriticUrl: String? = null,

	@ColumnInfo("alternativeNames")
	val alternativeNames: List<String>? = null,

	@ColumnInfo("parentsCount")
	val parentsCount: Int? = null,

	@ColumnInfo("platforms")
	val platforms: List<PlatformsItemEntity?>? = null,

	@ColumnInfo("metacriticPlatforms")
	val metacriticPlatforms: List<MetacriticPlatformsItemEntity?>? = null,

	@ColumnInfo("creatorsCount")
	val creatorsCount: Int? = null,

	@ColumnInfo("ratingTop")
	val ratingTop: Int? = null,

	@ColumnInfo("reviewsTextCount")
	val reviewsTextCount: String? = null,

	@ColumnInfo("ratings")
	val ratings: RatingsEntity? = null,

	@ColumnInfo("achievementsCount")
	val achievementsCount: Int? = null,

	@PrimaryKey
	@ColumnInfo("id")
	val id: Int? = null,

	@ColumnInfo("addedByStatus")
	val addedByStatus: AddedByStatusEntity?
	= null,
	@ColumnInfo("redditUrl")
	val redditUrl: String? = null,

	@ColumnInfo("redditName")
	val redditName: String? = null,

	@ColumnInfo("ratingsCount")
	val ratingsCount: Int? = null,

	@ColumnInfo("redditCount")
	val redditCount: Int? = null,

	@ColumnInfo("slug")
	val slug: String? = null,

	@ColumnInfo("released")
	val released: String? = null,

	@ColumnInfo("parentAchievementsCount")
	val parentAchievementsCount: String? = null,

	@ColumnInfo("website")
	val website: String? = null,

	@ColumnInfo("suggestionsCount")
	val suggestionsCount: Int? = null,

	@ColumnInfo("youtubeCount")
	val youtubeCount: String? = null,

	@ColumnInfo("additionsCount")
	val additionsCount: Int? = null,

	@ColumnInfo("moviesCount")
	val moviesCount: Int? = null,

	@ColumnInfo("twitchCount")
	val twitchCount: String? = null,

	@ColumnInfo("backgroundImageAdditional")
	val backgroundImageAdditional: String? = null,

	@ColumnInfo("backgroundImage")
	val backgroundImage: String? = null,

	@ColumnInfo("tba")
	val tba: Boolean? = null,

	@ColumnInfo("esrbRating")
	val esrbRating: EsrbRatingEntity? = null,

	@ColumnInfo("screenshotsCount")
	val screenshotsCount: Int? = null,

	@ColumnInfo("name")
	val name: String? = null,

	@ColumnInfo("redditDescription")
	val redditDescription: String? = null,

	@ColumnInfo("reactions")
	val reactions: ReactionsEntity? = null,

	@ColumnInfo("redditLogo")
	val redditLogo: String? = null,

	@ColumnInfo("updated")
	val updated: String? = null,

)

data class ReactionsEntity(
	@ColumnInfo("any")
	val any: Any? = null,
)

data class MetacriticPlatformsItemEntity(
	@ColumnInfo("metascore")
	val metascore: Int? = null,

	@ColumnInfo("url")
	val url: String? = null,
)


