package id.deval.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameResponse(

	@field:SerializedName("added")
	val added: Int? = null,

	@field:SerializedName("suggestions_count")
	val suggestionsCount: Int? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("metacritic")
	val metacritic: Int? = null,

	@field:SerializedName("playtime")
	val playtime: Int? = null,

	@field:SerializedName("platforms")
	val platforms: List<PlatformsItemResponse>? = null,

	@field:SerializedName("background_image")
	val backgroundImage: String? = null,

	@field:SerializedName("tba")
	val tba: Boolean? = null,

	@field:SerializedName("esrb_rating")
	val esrbRating: EsrbRatingResponse? = null,

	@field:SerializedName("rating_top")
	val ratingTop: Int? = null,

	@field:SerializedName("reviews_text_count")
	val reviewsTextCount: String? = null,

//	@field:SerializedName("ratings")
//	val ratings: Ratings? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

//	@field:SerializedName("added_by_status")
//	val addedByStatus: AddedByStatus? = null,

	@field:SerializedName("ratings_count")
	val ratingsCount: Int? = null,

	@field:SerializedName("updated")
	val updated: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("released")
	val released: String? = null,

	@field:SerializedName("genres")
	val genres: List<GenreResponse>? = null,

	@field:SerializedName("short_screenshots")
	val shortScreenshots: List<ShortScreenshotsResponse>? = null
)


data class ShortScreenshotsResponse(
	@field:SerializedName("id")
	val id : Int? = null,

	@field:SerializedName("image")
	val image : String? = null
)

data class PlatformsItemResponse(

	@field:SerializedName("requirements")
	val requirements: RequirementsResponse? = null,

	@field:SerializedName("released_at")
	val releasedAt: String? = null,

	@field:SerializedName("platform")
	val platform: PlatformResponse? = null
)

data class PlatformResponse(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class EsrbRatingResponse(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class RequirementsResponse(

	@field:SerializedName("minimum")
	val minimum: String? = null,

	@field:SerializedName("recommended")
	val recommended: String? = null
)

data class AddedByStatusResponse(
	//TODO(check object attributes api.rawg.io)
	val any: String? = null
)

data class RatingsResponse(
	//TODO(check object attributes api.rawg.io)
	val any: String? = null
)
