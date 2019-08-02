package com.rockycamacho.diversify.test.presentation.exercises.list

import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.rockycamacho.diversify.test.BaseRobolectricTest
import com.rockycamacho.diversify.test.data.network.ApiService
import com.rockycamacho.diversify.test.data.network.models.Exercise
import com.rockycamacho.diversify.test.di.TestComponent
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.`when`
import timber.log.Timber
import java.lang.RuntimeException

class ExercisesListViewModelTest : BaseRobolectricTest() {
    lateinit var viewModel: ExercisesListViewModel

    override fun injectDependencies(testComponent: TestComponent) {
        testComponent.inject(this)
    }

    @Test
    fun fetchData_Success() {
        //Given
        val items = Single.just(listOf<Exercise>(mock(), mock()))
        val apiService = mock<ApiService>()
        viewModel = ExercisesListViewModel(apiService)
        `when`(apiService.getExercises()).thenReturn(items)

        //When
        viewModel.fetchData()

        //Then
        verify(apiService).getExercises()
        assertFalse(viewModel.getLoadingIndicator().value!!)
        assertEquals("", viewModel.getErrorMessage().value)
        assertTrue(viewModel.getData().value!!.isNotEmpty())
    }


    @Test
    fun fetchData_Error() {
        //Given
        val apiService = mock<ApiService>()
        viewModel = ExercisesListViewModel(apiService)
        `when`(apiService.getExercises()).thenReturn(Single.error(RuntimeException("Http Error")))

        //When
        viewModel.fetchData()

        //Then
        verify(apiService).getExercises()
        assertFalse(viewModel.getLoadingIndicator().value!!)
        assertNotNull(viewModel.getErrorMessage().value)
        assertEquals("Http Error", viewModel.getErrorMessage().value)
        assertNull(viewModel.getData().value)
    }
}