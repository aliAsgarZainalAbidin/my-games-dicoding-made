package id.deval.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val added: Int? = null,

    val suggestionsCount: Int? = null,

    val rating: Double? = null,

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

    val released: String? = null,

    val genre : List<Genre>? = null,

    val shortScreenshots : List<ShortScreenshots>? = null
) : Parcelable


@Parcelize
data class ShortScreenshots(
    val id : Int? = null,

    val image : String? = null
) : Parcelable


@Parcelize
data class PlatformsItem(
    val requirements: Requirements? = null,

    val releasedAt: String? = null,

    val platform: Platform? = null
) : Parcelable

@Parcelize
data class Platform(
    val name: String? = null,

    val id: Int? = null,

    val slug: String? = null
) : Parcelable

@Parcelize
data class EsrbRating(
    val name: String? = null,

    val id: Int? = null,

    val slug: String? = null
) : Parcelable

@Parcelize
data class Requirements(
    val minimum: String? = null,

    val recommended: String? = null
) : Parcelable

@Parcelize
data class AddedByStatus(
    //TODO(check object attributes api.rawg.io)
    val any: String? = null
) : Parcelable

@Parcelize
data class Ratings(
    //TODO(check object attributes api.rawg.io)
    val any: String? = null
) : Parcelable