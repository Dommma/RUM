package hu.bme.aut.rum.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drink_database")
data class Drink(
    val type: String? = "",
    val ingredients: String? = "",
    val description: String? = "",
    val strDrink: String,
    val strDrinkThumb: String,
    @PrimaryKey val idDrink: String
) {
    constructor(): this("", "" ,"", "", "", "")
}