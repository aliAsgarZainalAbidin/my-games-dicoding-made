package id.deval.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "games")
data class GameEntity(
    @ColumnInfo("added")
    val added: Int? = null,

    @ColumnInfo("suggestionsCount")
    val suggestionsCount: Int? = null,

    @ColumnInfo("rating")
    val rating: Double? = null,

    @ColumnInfo("metacritic")
    val metacritic: Int? = null,

    @ColumnInfo("playtime")
    val playtime: Int? = null,

    @ColumnInfo("platforms")
    val platforms: List<PlatformsItemEntity?>? = null,

    @ColumnInfo("backgroundImage")
    val backgroundImage: String? = null,

    @ColumnInfo("tba")
    val tba: Boolean? = null,

    @ColumnInfo("esrbRating")
    val esrbRating: EsrbRatingEntity? = null,

    @ColumnInfo("ratingTop")
    val ratingTop: Int? = null,

    @ColumnInfo("reviewsTextCount")
    val reviewsTextCount: String? = null,

    @ColumnInfo("name")
    val name: String? = null,

    @PrimaryKey
    @ColumnInfo("id")
    val id: Int? = null,

    @ColumnInfo("ratingsCount")
    val ratingsCount: Int? = null,

    @ColumnInfo("updated")
    val updated: String? = null,

    @ColumnInfo("slug")
    val slug: String? = null,

    @ColumnInfo("released")
    val released: String? = null,

    @ColumnInfo("genre")
    val genre: List<GenreEntity>? = null,

    @ColumnInfo("shortScreenshots")
    val shortScreenshots: List<ShortScreenshotsEntity>? = null
)

@Entity(tableName = "short_screenshots")
data class ShortScreenshotsEntity(
    @field:SerializedName("id")
    val id : Int? = null,

    @field:SerializedName("image")
    val image : String? = null
)

@Entity(tableName = "platform_item")
data class PlatformsItemEntity(
    @ColumnInfo("requirements")
    val requirements: RequirementsEntity? = null,

    @ColumnInfo("releasedAt")
    val releasedAt: String? = null,

    @ColumnInfo("platform")
    val platform: PlatformEntity? = null
)

@Entity(tableName = "platform")
data class PlatformEntity(
    @ColumnInfo("name")
    val name: String? = null,

    @ColumnInfo("id")
    val id: Int? = null,

    @ColumnInfo("slug")
    val slug: String? = null
)

@Entity(tableName = "esrb_rating")
data class EsrbRatingEntity(
    @ColumnInfo("name")
    val name: String? = null,

    @ColumnInfo("id")
    val id: Int? = null,

    @ColumnInfo("slug")
    val slug: String? = null
)

@Entity(tableName = "requirements")
data class RequirementsEntity(
    @ColumnInfo("minimum")
    val minimum: String? = null,

    @ColumnInfo("recommended")
    val recommended: String? = null
)

@Entity(tableName = "added_by_status")
data class AddedByStatusEntity(
    val any: String? = null
)

@Entity(tableName = "ratings")
data class RatingsEntity(
    val any: String? = null
)
