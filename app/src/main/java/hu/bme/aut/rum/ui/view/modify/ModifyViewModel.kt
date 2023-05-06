package hu.bme.aut.rum.ui.view.modify

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class ModifyViewModel @Inject constructor(
    modifyRepository: ModifyRepository
): ViewModel() {

    private val drinkIdSharedFlow: MutableSharedFlow<Int> = MutableSharedFlow(replay = 1)

    val drinkFlow = drinkIdSharedFlow.flatMapLatest {
        modifyRepository.getDrinkById(it)
    }

    fun loadDrinkById(id: Int) = drinkIdSharedFlow.tryEmit(id)
}