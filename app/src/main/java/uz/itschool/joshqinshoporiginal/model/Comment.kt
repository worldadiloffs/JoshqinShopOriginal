package uz.itschool.joshqinshoporiginal.model

data class Comment(
    val body: String,
    val id: Int,
    val postId: Int,
    val user: User
)