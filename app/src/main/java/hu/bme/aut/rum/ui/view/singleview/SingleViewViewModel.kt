package hu.bme.aut.rum.ui.view.singleview

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class SingleViewViewModel @Inject constructor(

    singleViewRepository: SingleViewRepository
): ViewModel() {
    private val drinkIdSharedFlow: MutableSharedFlow<Int> = MutableSharedFlow(replay = 1)

    val drinkFlow = drinkIdSharedFlow.flatMapLatest {
        singleViewRepository.getDrinkById(it)
    }

    fun loadDrinkById(id: Int) = drinkIdSharedFlow.tryEmit(id)
}