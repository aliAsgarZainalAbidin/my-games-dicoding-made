package id.deval.core.domain.model


data class FavoriteGame(

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

    val genre: List<Genre>? = null,

    val shortScreenshots: List<ShortScreenshots>? = null,
)