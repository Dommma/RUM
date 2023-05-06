package hu.bme.aut.rum.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.rum.network.DrinkService
import hu.bme.aut.rum.persistance.DrinkDao
import hu.bme.aut.rum.ui.view.main.MainRepository
import hu.bme.aut.rum.ui.view.modify.ModifyRepository
import hu.bme.aut.rum.ui.view.singleview.SingleViewRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        drinkService: DrinkService,
        drinkDao: DrinkDao
    ): MainRepository {
        return MainRepository(drinkService, drinkDao)
    }

    @Provides
    @ViewModelScoped
    fun provideSingleViewRepository(
        drinkDao: DrinkDao
    ): SingleViewRepository {
        return SingleViewRepository(drinkDao)
    }

    @Provides
    @ViewModelScoped
    fun provideModifyRepository(
        drinkDao: DrinkDao
    ): ModifyRepository {
        return ModifyRepository(drinkDao)
    }
}