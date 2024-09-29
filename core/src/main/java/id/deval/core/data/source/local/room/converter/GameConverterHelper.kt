package id.deval.core.data.source.local.room.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.deval.core.data.source.local.entity.AddedByStatusEntity
import id.deval.core.data.source.local.entity.EsrbRatingEntity
import id.deval.core.data.source.local.entity.GenreEntity
import id.deval.core.data.source.local.entity.MetacriticPlatformsItemEntity
import id.deval.core.data.source.local.entity.PlatformsItemEntity
import id.deval.core.data.source.local.entity.RatingsEntity
import id.deval.core.data.source.local.entity.ReactionsEntity
import id.deval.core.data.source.local.entity.ShortScreenshotsEntity

class GameConverterHelper {
    @TypeConverter
    fun fromArrayString(value: ArrayList<String>?) = Gson().toJson(value)

    @TypeConverter
    fun toArrayString(value: String) =
        Gson().fromJson<ArrayList<String>>(value, object : TypeToken<ArrayList<String>>() {}.type)

    @TypeConverter
    fun fromListString(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun toListString(value: String) =
        Gson().fromJson<List<String>>(value, object : TypeToken<List<String>>() {}.type)


    @TypeConverter
    fun fromArrayPlatformsItemEntityOrNull(value: List<PlatformsItemEntity?>?) = Gson().toJson(value)

    @TypeConverter
    fun toArrayPlatformsItemEntityOrNull(value: String) = Gson().fromJson<List<PlatformsItemEntity?>>(
        value,
        object : TypeToken<List<PlatformsItemEntity?>>() {}.type
    )

    @TypeConverter
    fun fromListMetacriticPlatformsItemEntityOrNull(value: List<MetacriticPlatformsItemEntity?>?) =
        Gson().toJson(value)

    @TypeConverter
    fun toListMetacriticPlatformsItemEntityOrNull(value: String) =
        Gson().fromJson<List<MetacriticPlatformsItemEntity>>(
            value,
            object : TypeToken<List<MetacriticPlatformsItemEntity?>>() {}.type
        )

    @TypeConverter
    fun fromListGenreEntity(value: List<GenreEntity>?) =
        Gson().toJson(value)

    @TypeConverter
    fun toListGenreEntity(value: String) =
        Gson().fromJson<List<GenreEntity>>(
            value,
            object : TypeToken<List<GenreEntity>>() {}.type
        )

    @TypeConverter
    fun fromListShortScreenshotsEntity(value: List<ShortScreenshotsEntity>?) =
        Gson().toJson(value)

    @TypeConverter
    fun toListShortScreenshotsEntity(value: String) =
        Gson().fromJson<List<ShortScreenshotsEntity>>(
            value,
            object : TypeToken<List<ShortScreenshotsEntity>>() {}.type
        )

    @TypeConverter
    fun fromRatingsEntity(value: RatingsEntity?) = Gson().toJson(value)

    @TypeConverter
    fun toRatingsEntity(value: String) = Gson().fromJson<RatingsEntity>(
        value,
        object : TypeToken<RatingsEntity>() {}.type
    )

    @TypeConverter
    fun fromAddedByStatusEntity(value: AddedByStatusEntity?) = Gson().toJson(value)

    @TypeConverter
    fun toAddedByStatusEntity(value: String) = Gson().fromJson<AddedByStatusEntity>(
        value,
        object : TypeToken<AddedByStatusEntity>() {}.type
    )

    @TypeConverter
    fun fromEsrbRatingEntity(value: EsrbRatingEntity?) = Gson().toJson(value)

    @TypeConverter
    fun toEsrbRatingEntity(value: String) = Gson().fromJson<EsrbRatingEntity>(
        value,
        object : TypeToken<AddedByStatusEntity>() {}.type
    )

    @TypeConverter
    fun fromReactionEntity(value: ReactionsEntity?) = Gson().toJson(value)

    @TypeConverter
    fun toReactionEntity(value: String) = Gson().fromJson<ReactionsEntity>(
        value,
        object : TypeToken<ReactionsEntity>() {}.type
    )

    @TypeConverter
    fun fromGenreEntity(value: GenreEntity?) = Gson().toJson(value)

    @TypeConverter
    fun toGenreEntity(value: String) = Gson().fromJson<GenreEntity>(
        value,
        object : TypeToken<GenreEntity>() {}.type
    )

}