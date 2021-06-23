package com.bignerdranch.android.artbooktesting.dependecyinjection

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.artbooktesting.R
import com.bignerdranch.android.artbooktesting.api.RetrofitAPI
import com.bignerdranch.android.artbooktesting.repo.ArtRepository
import com.bignerdranch.android.artbooktesting.repo.ArtRepositoryInterface
import com.bignerdranch.android.artbooktesting.roomdb.ArtDao
import com.bignerdranch.android.artbooktesting.roomdb.ArtDatabase
import com.bignerdranch.android.artbooktesting.util.Util.BASE_URL
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRoomDatabase(@ApplicationContext context: Context) =
        Room
            .databaseBuilder(context, ArtDatabase::class.java, "ArtBookDB")
            .build()

    @Singleton
    @Provides
    fun injectDao(database: ArtDatabase) = database.artDao()

    @Singleton
    @Provides
    fun injectRetrofitAPI() : RetrofitAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RetrofitAPI::class.java)
    }

    @Singleton
    @Provides
    fun injectNormalRepo(dao: ArtDao, api: RetrofitAPI) =
        ArtRepository(dao, api) as ArtRepositoryInterface

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) =
        Glide.with(context)
            .setDefaultRequestOptions(
                RequestOptions().placeholder(R.drawable.globe)
                    .error(R.drawable.ic_launcher_background)
            )

}