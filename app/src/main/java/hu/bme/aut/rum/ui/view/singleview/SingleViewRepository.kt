package hu.bme.aut.rum.ui.view.singleview

import androidx.annotation.WorkerThread
import hu.bme.aut.rum.model.Drink
import hu.bme.aut.rum.persistance.DrinkDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SingleViewRepository @Inject constructor(
    private val drinkDao: DrinkDao
) {
    @WorkerThread
    fun getDrinkById(id: Int) = flow {
        val drink = drinkDao.getDrink(id)
        emit(drink)
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun deleteDrink(drink: Drink) = flow {
        drinkDao.delete(drink)
        emit(null)
    }.flowOn(Dispatchers.IO)
}