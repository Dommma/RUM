package hu.bme.aut.rum.persistance

import androidx.room.*
import hu.bme.aut.rum.model.Drink

@Dao
interface DrinkDao {
    @Query("SELECT * from drink")
    fun getAllDrinks(): List<Drink>

    @Query("SELECT * from drink WHERE id = :id")
    fun getDrink(id: Int): Drink

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinkList(drinks: List<Drink>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(drink: Drink)

    @Update
    suspend fun update(drink: Drink)

    @Delete
    suspend fun delete(drink: Drink)
}