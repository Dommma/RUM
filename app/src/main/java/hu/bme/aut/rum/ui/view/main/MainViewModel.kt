package hu.bme.aut.rum.ui.view.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.rum.model.Drink
import hu.bme.aut.rum.network.DrinkService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository
) : ViewModel() {

    val drinkList: Flow<List<Drink>> = mainRepository.getDrinks(
        onStart = {},
        onCompletion = {},
        onError = {}
    ) as Flow<List<Drink>>
}