package id.deval.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
	val gamesCount: Int? = null,
	val name: String? = null,
	val id: Int? = null,
	val imageBackground: String? = null,
	val slug: String? = null
) : Parcelable

