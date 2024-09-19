package id.deval.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genres")
data class GenreEntity(

    @ColumnInfo(name = "gamesCount")
    val gamesCount: Int? = null,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "imageBackground")
    val imageBackground: String? = null,

    @ColumnInfo(name = "slug")
    val slug: String? = null
)