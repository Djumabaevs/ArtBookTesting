package com.bignerdranch.android.artbooktesting.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bignerdranch.android.artbooktesting.model.ImageResponse
import com.bignerdranch.android.artbooktesting.roomdb.Art
import com.bignerdranch.android.artbooktesting.util.Resource

class FakeArtRepository: ArtRepositoryInterface {

    private val arts = mutableListOf<Art>()
    private val artsLiveData = MutableLiveData<List<Art>>(arts)

    override suspend fun insertArt(art: Art) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteArt(art: Art) {
        TODO("Not yet implemented")
    }

    override fun getArt(): LiveData<List<Art>> {
        TODO("Not yet implemented")
    }

    override suspend fun imageSearch(imageString: String): Resource<ImageResponse> {
        TODO("Not yet implemented")
    }


}