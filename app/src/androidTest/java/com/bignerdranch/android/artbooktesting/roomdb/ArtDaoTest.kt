package com.bignerdranch.android.artbooktesting.roomdb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule

@SmallTest
@ExperimentalCoroutinesApi
class ArtDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: ArtDao
    private lateinit var database: ArtDatabase

    @Before
    fun setUp() {

        database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                ArtDatabase::class.java).allowMainThreadQueries().build()

        dao =database.artDao()

    }

    @After
    fun tearDown() {
        database.close()
    }

}