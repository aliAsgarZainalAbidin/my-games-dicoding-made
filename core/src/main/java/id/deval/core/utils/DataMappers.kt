package id.deval.core.utils

import id.deval.core.data.source.local.entity.DetailGameEntity
import id.deval.core.data.source.local.entity.FavoriteGameEntity
import id.deval.core.data.source.local.entity.GameEntity
import id.deval.core.data.source.remote.response.DetailGameResponse
import id.deval.core.data.source.remote.response.GameResponse
import id.deval.core.domain.model.DetailGame
import id.deval.core.domain.model.FavoriteGame
import id.deval.core.domain.model.Game

object DataMappers {

    fun mapGameResponsesToEntities(input: List<GameResponse>): List<GameEntity> {
        val listGame = ArrayList<GameEntity>()
        input.map {
            val game = GameEntity(
                name = it.name,
                added = it.added,
                suggestionsCount = it.suggestionsCount,
                rating = it.rating,
                metacritic = it.metacritic,
                playtime = it.playtime,
                backgroundImage = it.backgroundImage,
                tba = it.tba,
                id = it.id,
                ratingTop = it.ratingTop,
                reviewsTextCount = it.reviewsTextCount,
                ratingsCount = it.ratingsCount,
                updated = it.updated,
                slug = it.slug,
                released = it.released,
                genre = it.genres?.map { genre -> genre.toEntity() },
                platforms = it.platforms?.map { plt -> plt?.toEntity() },
                shortScreenshots = it.shortScreenshots?.map { sc -> sc.toEntity() }
            )
            listGame.add(game)
        }
        return listGame
    }

    fun mapGameEntitiesToDomain(input: List<GameEntity>) =
        input.map {
            Game(
                name = it.name,
                added = it.added,
                suggestionsCount = it.suggestionsCount,
                rating = it.rating,
                metacritic = it.metacritic,
                playtime = it.playtime,
                backgroundImage = it.backgroundImage,
                tba = it.tba,
                id = it.id,
                ratingTop = it.ratingTop,
                reviewsTextCount = it.reviewsTextCount,
                ratingsCount = it.ratingsCount,
                updated = it.updated,
                slug = it.slug,
                released = it.released,
                genre = it.genre?.map { genre -> genre.toDomain() },
                platforms = it.platforms?.map { plt -> plt?.toDomain() },
                shortScreenshots = it.shortScreenshots?.map { sc -> sc.toDomain() },
                isFavorite = it.isFavorite
            )
        }

    fun mapDetailGameEntityToDomain(input: DetailGameEntity) = DetailGame(
        added = input.added,
        nameOriginal = input.nameOriginal,
        metacritic = input.metacritic,
        rating = input.rating,
        description = input.description,
        gameSeriesCount = input.gameSeriesCount,
        playtime = input.playtime,
        metacriticUrl = input.metacriticUrl,
        alternativeNames = input.alternativeNames,
        parentsCount = input.parentsCount,
        platforms = input.platforms?.map { it?.toDomain() },
        metacriticPlatforms = input.metacriticPlatforms?.map { it?.toDomain() },
        creatorsCount = input.creatorsCount,
        ratingTop = input.ratingTop,
        reviewsTextCount = input.reviewsTextCount,
        ratings = input.ratings?.toDomain(),
        achievementsCount = input.achievementsCount,
        id = input.id,
        addedByStatus = input.addedByStatus?.toDomain(),
        redditUrl = input.redditUrl,
        redditName = input.redditName,
        ratingsCount = input.ratingsCount,
        redditCount = input.redditCount,
        slug = input.slug,
        released = input.released,
        parentAchievementsCount = input.parentAchievementsCount,
        website = input.website,
        suggestionsCount = input.suggestionsCount,
        youtubeCount = input.youtubeCount,
        additionsCount = input.additionsCount,
        moviesCount = input.moviesCount,
        twitchCount = input.twitchCount,
        backgroundImageAdditional = input.backgroundImageAdditional,
        backgroundImage = input.backgroundImage,
        tba = input.tba,
        esrbRating = input.esrbRating?.toDomain(),
        screenshotsCount = input.screenshotsCount,
        name = input.name,
        redditDescription = input.redditDescription,
        reactions = input.reactions?.toDomain(),
        redditLogo = input.redditLogo,
        updated = input.updated
    )

    fun mapDetailGameResponseToEntity(input: DetailGameResponse) = DetailGameEntity(
        added = input.added,
        nameOriginal = input.nameOriginal,
        metacritic = input.metacritic,
        rating = input.rating,
        description = input.description,
        gameSeriesCount = input.gameSeriesCount,
        playtime = input.playtime,
        metacriticUrl = input.metacriticUrl,
        alternativeNames = input.alternativeNames,
        parentsCount = input.parentsCount,
        platforms = input.platforms?.map {
            it.toEntity()
        },
        metacriticPlatforms = input.metacriticPlatforms?.map {
            it.toEntity()
        },
        creatorsCount = input.creatorsCount,
        ratingTop = input.ratingTop,
        reviewsTextCount = input.reviewsTextCount,
        ratings = input.ratings?.toEntity(),
        achievementsCount = input.achievementsCount,
        id = input.id,
        addedByStatus = input.addedByStatus?.toEntity(),
        redditUrl = input.redditUrl,
        redditName = input.redditName,
        ratingsCount = input.ratingsCount,
        redditCount = input.redditCount,
        slug = input.slug,
        released = input.released,
        parentAchievementsCount = input.parentAchievementsCount,
        website = input.website,
        suggestionsCount = input.suggestionsCount,
        youtubeCount = input.youtubeCount,
        additionsCount = input.additionsCount,
        moviesCount = input.moviesCount,
        twitchCount = input.twitchCount,
        backgroundImageAdditional = input.backgroundImageAdditional,
        backgroundImage = input.backgroundImage,
        tba = input.tba,
        esrbRating = input.esrbRating?.toEntity(),
        screenshotsCount = input.screenshotsCount,
        name = input.name,
        redditDescription = input.redditDescription,
        reactions = input.reactions?.toEntity(),
        redditLogo = input.redditLogo,
        updated = input.updated
    )

    fun mapGameDomainToEntity(input: Game) = GameEntity(
        name = input.name,
        added = input.added,
        suggestionsCount = input.suggestionsCount,
        rating = input.rating,
        metacritic = input.metacritic,
        playtime = input.playtime,
        backgroundImage = input.backgroundImage,
        tba = input.tba,
        id = input.id,
        ratingTop = input.ratingTop,
        reviewsTextCount = input.reviewsTextCount,
        ratingsCount = input.ratingsCount,
        updated = input.updated,
        slug = input.slug,
        released = input.released,
        genre = input.genre?.map { it.toEntity() },
        platforms = input.platforms?.map { it?.toEntity() },
        shortScreenshots = input.shortScreenshots?.map { it.toEntity() },
        isFavorite = input.isFavorite
    )

    fun mapFavoriteEntityToDomain(input: List<FavoriteGameEntity>): List<FavoriteGame> {
        val listFavorite = ArrayList<FavoriteGame>()
        input.map {
            val favorite = FavoriteGame(
                id = it.id,
                name = it.name,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                released = it.released,
                metacritic = it.metacritic,
                genre = it.genre?.map { genre -> genre.toDomain() },
                platforms = it.platforms?.map { plt -> plt?.toDomain() },
                shortScreenshots = it.shortScreenshots?.map { sc -> sc.toDomain() },
                updated = it.updated,
                slug = it.slug,
                added = it.added,
                suggestionsCount = it.suggestionsCount,
                tba = it.tba,
                esrbRating = it.esrbRating?.toDomain()
            )
            listFavorite.add(favorite)
        }
        return listFavorite
    }

    fun mapFavoriteDomainToEntity(input: List<FavoriteGame>): List<FavoriteGameEntity> {
        val listFavorite = ArrayList<FavoriteGameEntity>()
        input.map {
            val favorite = FavoriteGameEntity(
                id = it.id,
                name = it.name,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                released = it.released,
                metacritic = it.metacritic,
                genre = it.genre?.map { genre -> genre.toEntity() },
                platforms = it.platforms?.map { plt -> plt?.toEntity() },
                shortScreenshots = it.shortScreenshots?.map { sc -> sc.toEntity() },
                updated = it.updated,
                slug = it.slug,
                added = it.added,
                suggestionsCount = it.suggestionsCount,
                tba = it.tba,
                esrbRating = it.esrbRating?.toEntity(),
            )
            listFavorite.add(favorite)
        }
        return listFavorite
    }

    fun favoriteGameEntityToDomain(input: FavoriteGameEntity) = FavoriteGame(
        added = input.added,
        suggestionsCount = input.suggestionsCount,
        rating = input.rating,
        metacritic = input.metacritic,
        playtime = input.playtime,
        platforms = input.platforms?.map { it?.toDomain() },
        backgroundImage = input.backgroundImage,
        tba = input.tba,
        esrbRating = input.esrbRating?.toDomain(),
        ratingTop = input.ratingTop,
        updated = input.updated,
        slug = input.slug,
        released = input.released,
        genre = input.genre?.map { it.toDomain() },
        shortScreenshots = input.shortScreenshots?.map { it.toDomain() },
        name = input.name,
        id = input.id,
        ratingsCount = input.ratingsCount,
    )

    fun favoriteGameDomainToEntity(input : FavoriteGame) = FavoriteGameEntity(
        added = input.added,
        suggestionsCount = input.suggestionsCount,
        rating = input.rating,
        metacritic = input.metacritic,
        playtime = input.playtime,
        platforms = input.platforms?.map { it?.toEntity() },
        backgroundImage = input.backgroundImage,
        tba = input.tba,
        esrbRating = input.esrbRating?.toEntity(),
        ratingTop = input.ratingTop,
        updated = input.updated,
        slug = input.slug,
        released = input.released,
        genre = input.genre?.map { it.toEntity() },
        shortScreenshots = input.shortScreenshots?.map { it.toEntity() },
        name = input.name,
        id = input.id,
        ratingsCount = input.ratingsCount
    )

}