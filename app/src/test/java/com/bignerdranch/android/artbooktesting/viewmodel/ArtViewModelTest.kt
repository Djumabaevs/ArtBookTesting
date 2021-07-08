package com.bignerdranch.android.artbooktesting.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bignerdranch.android.artbooktesting.MainCoroutineRule
import com.bignerdranch.android.artbooktesting.getOrAwaitValueTest
import com.bignerdranch.android.artbooktesting.repo.FakeArtRepository
import com.bignerdranch.android.artbooktesting.util.Status
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ArtViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ArtViewModel

    @Before
    fun setup() {
        viewModel = ArtViewModel(FakeArtRepository())
    }

    @Test
    fun `insert art without year returns error`() {
        viewModel.makeArt("Mona Lisa", " Da Vinci", "")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)

    }

    @Test
    fun `insert art without name returns error`() {
        viewModel.makeArt("", "Da Vinci", "1700")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert art without artistName returns error`() {
        viewModel.makeArt("Mona Lisa", "", "1700")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }

}