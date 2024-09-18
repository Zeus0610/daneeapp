package com.zeus.daneeapp.ui.viewModel

import com.zeus.daneeapp.domian.interactors.AddCharacterToFavoritesUseCase
import com.zeus.daneeapp.domian.interactors.GetCharacterByIdUseCase
import com.zeus.daneeapp.domian.models.Character
import com.zeus.daneeapp.utils.Constants.character
import com.zeus.daneeapp.utils.Constants.favoriteCharacter
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class DetailsViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var detailsViewModel: DetailsViewModel

    @Mock
    private lateinit var getCharacterByIdUseCase: GetCharacterByIdUseCase

    private val addCharacterToFavoritesUseCase: AddCharacterToFavoritesUseCase = mock()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        detailsViewModel = DetailsViewModel(
            getCharacterByIdUseCase,
            addCharacterToFavoritesUseCase
        )
    }


    @Test
    fun `Test getCharacterById when character is found`() = runTest {
        whenever(getCharacterByIdUseCase.invoke(anyString())).thenReturn( flowOf(character) )

        detailsViewModel.getCharacterById("1")

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals("Character is not equals", character, detailsViewModel.state.value.character)
    }

    @Test
    fun `Test getCharacterById when character is not found`() =  runTest {
        whenever(getCharacterByIdUseCase.invoke(anyString())).thenReturn(flowOf<Character?>(null))

        detailsViewModel.getCharacterById("1")

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals("Character is not null", Character(), detailsViewModel.state.value.character)
    }

    @Test
    fun `Test getCharacterById when character is a favorite`() =  runTest {
        whenever(getCharacterByIdUseCase.invoke(anyString())).thenReturn( flowOf(favoriteCharacter) )

        detailsViewModel.getCharacterById("1")

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals("Character is not a favorite", favoriteCharacter, detailsViewModel.state.value.character)
    }

    @Test
    fun `Test getCharacterById when hasError`() = runTest {
        whenever(getCharacterByIdUseCase.invoke(anyString())).thenReturn( flow { throw Exception("Test error") })

        detailsViewModel.getCharacterById("2")

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals("hasError is true", true, detailsViewModel.state.value.hasError)

    }

    @Test
    fun `Test call addToFavorites`() = runTest {
        detailsViewModel.addToFavorites()

        testDispatcher.scheduler.advanceUntilIdle()

        verify(addCharacterToFavoritesUseCase, times(1)).invoke(any())
    }
}