package hu.bme.aut.rum.ui.view.modify

import androidx.annotation.WorkerThread
import hu.bme.aut.rum.model.Drink
import hu.bme.aut.rum.persistance.DrinkDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ModifyRepository @Inject constructor(
    private val drinkDao: DrinkDao
) {
    @WorkerThread
    fun getDrinkById(id: String) = flow {
        val drink = drinkDao.getDrink(id)
        emit(drink)
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun updateDrink(drink: Drink) = flow {
        drinkDao.update(drink)
        emit(null)
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun saveNewDrink(drink: Drink) = flow {
        drinkDao.insert(drink)
        emit(null)
    }.flowOn(Dispatchers.IO)
}