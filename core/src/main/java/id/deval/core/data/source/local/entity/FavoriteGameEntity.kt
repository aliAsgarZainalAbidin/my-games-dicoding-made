package id.deval.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favorite_game")
data class FavoriteGameEntity(

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
    val shortScreenshots: List<ShortScreenshotsEntity>? = null,

    @ColumnInfo("isFavorite")
    var isFavorite: Boolean? = null
)