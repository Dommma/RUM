package hu.bme.aut.rum.ui.view.main

import androidx.annotation.WorkerThread
import hu.bme.aut.rum.model.Drink
import hu.bme.aut.rum.network.DrinkService
import hu.bme.aut.rum.persistance.DrinkDao
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val drinkService: DrinkService,
    private val drinkDao: DrinkDao
) {

    @WorkerThread
    fun getDrinks(
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val drinks: List<Drink> = drinkDao.getAllDrinks()
        if(drinks.isEmpty()) {
            try {
                val response = drinkService.fetchAllDrinks()
                response.body()?.let {
                    drinkDao.insertDrinkList(it.drinks)
                    emit(it.drinks)
                }
            } catch (throwable: Throwable) {
                emit(onError("Betöltési hiba"))
            }
        } else {
            emit(drinks)
        }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)

}