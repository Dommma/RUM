package hu.bme.aut.rum.model

data class Drink(
    val name: String,
    val type: String,
    val imageUrl: String,
    val ingredients: List<Ingredient>,
    val description: String
) {
}