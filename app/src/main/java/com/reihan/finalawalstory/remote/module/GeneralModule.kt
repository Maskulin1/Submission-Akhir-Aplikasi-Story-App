package com.reihan.finalawalstory.remote.module

import android.content.SharedPreferences
import com.reihan.finalawalstory.remote.database.StoryDatabase
import com.reihan.finalawalstory.ui.detail.DetailViewModel
import com.reihan.finalawalstory.ui.login.LoginViewModel
import com.reihan.finalawalstory.ui.register.RegisterViewModel
import com.reihan.finalawalstory.remote.preferences.SettingPreferences
import com.reihan.finalawalstory.ui.detail.DetailRepository
import com.reihan.finalawalstory.ui.detail.DetailService
import com.reihan.finalawalstory.ui.login.LoginService
import com.reihan.finalawalstory.ui.location.MapsService
import com.reihan.finalawalstory.ui.register.RegisterService
import com.reihan.finalawalstory.ui.login.LoginRepository
import com.reihan.finalawalstory.ui.location.MapsRepository
import com.reihan.finalawalstory.ui.location.MapsViewModel
import com.reihan.finalawalstory.ui.main.MainRepository
import com.reihan.finalawalstory.ui.main.MainService
import com.reihan.finalawalstory.ui.main.MainViewModel
import com.reihan.finalawalstory.ui.register.RegisterRepository
import com.reihan.finalawalstory.ui.story.NewStoryRepository
import com.reihan.finalawalstory.ui.story.NewStoryService
import com.reihan.finalawalstory.ui.story.NewStoryViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRegisterRepository(registerService: RegisterService) =
        RegisterRepository(registerService)

    @Provides
    @Singleton
    fun provideLoginRepository(loginService: LoginService) = LoginRepository(loginService)

    @Provides
    @Singleton
    fun provideMainRepository(storyDatabase: StoryDatabase, mainService: MainService) =
        MainRepository(storyDatabase, mainService)

    @Provides
    @Singleton
    fun provideDetailRepository(detailStoryService: DetailService) =
        DetailRepository(detailStoryService)

    @Provides
    @Singleton
    fun provideNewStoryRepository(newStoryService: NewStoryService) =
        NewStoryRepository(newStoryService)

    @Provides
    @Singleton
    fun provideStoryCoordinatesRepository(mapsService: MapsService) = MapsRepository(mapsService)
}

@Module
@InstallIn(SingletonComponent::class)
object ViewModelModule {
    @Provides
    @Singleton
    fun provideRegisterViewModel(registerRepository: RegisterRepository) =
        RegisterViewModel(registerRepository)

    @Provides
    @Singleton
    fun provideLoginViewModel(loginRepository: LoginRepository) = LoginViewModel(loginRepository)

    @Provides
    @Singleton
    fun provideMainViewModel(mainRepository: MainRepository) = MainViewModel(mainRepository)

    @Provides
    @Singleton
    fun provideNewStoryViewModel(newStoryRepository: NewStoryRepository) =
        NewStoryViewModel(newStoryRepository)

    @Provides
    @Singleton
    fun provideDetailViewModel(detailRepository: DetailRepository) =
        DetailViewModel(detailRepository)

    @Provides
    @Singleton
    fun provideMapsViewModel(mapsRepository: MapsRepository) = MapsViewModel(mapsRepository)
}

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {
    @Provides
    @Singleton
    fun provideUserPreferences(sharedPreferences: SharedPreferences) =
        SettingPreferences(sharedPreferences)
}