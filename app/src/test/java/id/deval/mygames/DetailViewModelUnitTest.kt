package id.deval.mygames

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.deval.core.domain.model.Game
import id.deval.core.domain.usecase.FavoriteGameUsecase
import id.deval.mygames.detail.DetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelUnitTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mockitJunitRule = MockitoJUnit.rule()

    @Mock
    private lateinit var favoriteGameUsecase : FavoriteGameUsecase
    private lateinit var detailViewModel : DetailViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)

        detailViewModel = DetailViewModel(favoriteGameUsecase)
    }

    @Test
    fun `setFavoriteGame call use case correctly`() = runTest {
        val game = Game(name = "Mario Bros")
        detailViewModel.setFavoriteGame(game)

        advanceUntilIdle()
        Mockito.verify(favoriteGameUsecase, Mockito.times(1)).setFavoriteGame(game)
    }

}