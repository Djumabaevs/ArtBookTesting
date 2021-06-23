package com.bignerdranch.android.artbooktesting.repo

import androidx.lifecycle.LiveData
import com.bignerdranch.android.artbooktesting.model.ImageResponse
import com.bignerdranch.android.artbooktesting.roomdb.Art
import com.bignerdranch.android.artbooktesting.util.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art: Art)

    suspend fun deleteArt(art: Art)

    fun getArt(): LiveData<List<Art>>

    suspend fun imageSearch(imageString: String): Resource<ImageResponse>

}