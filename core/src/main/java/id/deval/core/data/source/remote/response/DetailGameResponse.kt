package id.deval.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data
class DetailGameResponse(
	@field:SerializedName("added")
	val added: Int? = null,

	@field:SerializedName("nameOriginal")
	val nameOriginal: String? = null,

	@field:SerializedName("metacritic")
	val metacritic: Int? = null,

	@field:SerializedName("rating")
	val rating: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("gameSeriesCount")
	val gameSeriesCount: Int? = null,

	@field:SerializedName("playtime")
	val playtime: Int? = null,

	@field:SerializedName("metacriticUrl")
	val metacriticUrl: String? = null,

	@field:SerializedName("alternativeNames")
	val alternativeNames: List<String>? = null,

	@field:SerializedName("parentsCount")
	val parentsCount: Int? = null,

	@field:SerializedName("platforms")
	val platforms: List<PlatformsItemResponse>? = null,

	@field:SerializedName("metacriticPlatforms")
	val metacriticPlatforms: List<MetacriticPlatformsItemResponse>? = null,

	@field:SerializedName("creatorsCount")
	val creatorsCount: Int? = null,

	@field:SerializedName("ratingTop")
	val ratingTop: Int? = null,

	@field:SerializedName("reviewsTextCount")
	val reviewsTextCount: String? = null,

	@field:SerializedName("ratings")
	val ratings: RatingsResponse? = null,

	@field:SerializedName("achievementsCount")
	val achievementsCount: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("addedByStatus")
	val addedByStatus: AddedByStatusResponse? = null,

	@field:SerializedName("redditUrl")
	val redditUrl: String? = null,

	@field:SerializedName("redditName")
	val redditName: String? = null,

	@field:SerializedName("ratingsCount")
	val ratingsCount: Int? = null,

	@field:SerializedName("redditCount")
	val redditCount: Int? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("released")
	val released: String? = null,

	@field:SerializedName("parentAchievementsCount")
	val parentAchievementsCount: String? = null,

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("suggestionsCount")
	val suggestionsCount: Int? = null,

	@field:SerializedName("youtubeCount")
	val youtubeCount: String? = null,

	@field:SerializedName("additionsCount")
	val additionsCount: Int? = null,

	@field:SerializedName("moviesCount")
	val moviesCount: Int? = null,

	@field:SerializedName("twitchCount")
	val twitchCount: String? = null,

	@field:SerializedName("backgroundImageAdditional")
	val backgroundImageAdditional: String? = null,

	@field:SerializedName("backgroundImage")
	val backgroundImage: String? = null,

	@field:SerializedName("tba")
	val tba: Boolean? = null,

	@field:SerializedName("esrbRating")
	val esrbRating: EsrbRatingResponse? = null,

	@field:SerializedName("screenshotsCount")
	val screenshotsCount: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("redditDescription")
	val redditDescription: String? = null,

	@field:SerializedName("reactions")
	val reactions: ReactionsResponse? = null,

	@field:SerializedName("redditLogo")
	val redditLogo: String? = null,

	@field:SerializedName("updated")
	val updated: String? = null,

)

data class ReactionsResponse(
	@field:SerializedName("any")
	val any: Any? = null,
)

data class MetacriticPlatformsItemResponse(
	@field:SerializedName("metascore")
	val metascore: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,
)


