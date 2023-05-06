package hu.bme.aut.rum.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.bme.aut.rum.model.Drink

@Database(entities = [Drink::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun drinkDao(): DrinkDao
}