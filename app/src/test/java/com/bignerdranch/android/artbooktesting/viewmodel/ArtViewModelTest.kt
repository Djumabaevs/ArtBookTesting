package com.bignerdranch.android.artbooktesting.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bignerdranch.android.artbooktesting.repo.FakeArtRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ArtViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ArtViewModel

    @Before
    fun setup() {
        viewModel = ArtViewModel(FakeArtRepository())
    }

    @Test
    fun `insert art without year returns error`() {
        viewModel.makeArt("Mona Lisa", " Da Vinci", "")
        val value = viewModel.insertArtMessage

    }

    @Test
    fun `insert art without name returns error`() {

    }

    @Test
    fun `insert art without artistName returns error`() {

    }

}