package uz.itschool.joshqinshoporiginal.model

data class CartData(
    val carts: List<Cart>,
    val limit: Int,
    val skip: Int,
    val total: Int
)
