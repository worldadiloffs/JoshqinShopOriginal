package uz.itschool.joshqinshoporiginal.networking

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import uz.itschool.joshqinshoporiginal.model.CartData
import uz.itschool.joshqinshoporiginal.model.CommentData
import uz.itschool.joshqinshoporiginal.model.Login
import uz.itschool.joshqinshoporiginal.model.ProductData
import uz.itschool.joshqinshoporiginal.model.User

interface APIService {

    @GET("/products")
    fun getAllProducts(): Call<ProductData>

    @GET("/products/categories")
    fun getAllCategories(): Call<List<String>>

    @GET("/products/category/{categoryName}")
    fun getProductByCategory(@Path("categoryName") categoryName: String): Call<ProductData>

    @GET("/products/search")
    fun searchByName(@Query("q") name: String): Call<ProductData>

    @POST("/auth/login")
    fun login(@Body login: Login): Call<User>

    @POST("/comments/add")
    fun addComments(@Body body: String): Call<CommentData>

    @GET("/comments")
    fun getAllComments(): Call<CommentData>

    @GET("/carts/user/{id}")
    fun getBuyedById(@Path("id")id: Int): Call<CartData>

}