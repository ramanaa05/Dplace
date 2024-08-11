package com.example.dplace.presentation.sign_in

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private val retrofit = Retrofit
    .Builder()
    .baseUrl("http://127.0.0.1:8000")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService: ApiServices = retrofit.create(ApiServices::class.java)

interface ApiServices {
    @GET("/grid/full/")
    suspend fun getGrid(): Grid

    @POST("/grid/update/")
    suspend fun updateGrid(@Body cell: Cell): Cell
}

data class Cell(
    val index: Int,
    val color: String?,
    val occupied: String?
)

data class Grid(
    val grid: List<Cell>
)