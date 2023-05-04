package hu.bme.aut.rum.network

import hu.bme.aut.rum.model.Drink
import retrofit2.Response
import retrofit2.http.GET

interface DrinkService {

    companion object {
        const val BASE_URL = "www.thecocktaildb.com/"
    }

    @GET("api/json/v1/1/filter.php?i=Rum")
    suspend fun fetchAllDrinks(): Response<List<Drink>>
}