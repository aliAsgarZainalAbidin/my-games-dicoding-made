package id.deval.core.utils

import id.deval.core.data.source.local.entity.DetailGameEntity
import id.deval.core.data.source.local.entity.GameEntity
import id.deval.core.data.source.remote.response.DetailGameResponse
import id.deval.core.data.source.remote.response.GameResponse
import id.deval.core.domain.model.DetailGame
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
                released = it.released
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
                released = it.released
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
        released = input.released
    )
}