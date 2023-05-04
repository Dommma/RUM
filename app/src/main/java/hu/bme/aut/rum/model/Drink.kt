package hu.bme.aut.rum.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drink")
data class Drink(
    @PrimaryKey(autoGenerate = true)  val id: Int,
    val name: String,
    val type: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    val ingredients: String,
    val description: String?
) {
    constructor(): this(0,"", "", "", "", "")
}