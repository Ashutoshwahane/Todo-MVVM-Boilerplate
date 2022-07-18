package xyz.cybernerd404.todo_mvvm_boilerplate.network

import retrofit2.Response
import retrofit2.http.GET
import xyz.cybernerd404.todo_mvvm_boilerplate.model.DataResponse

interface TodoApi {

    @GET("todos")
    suspend fun getTodoList(): Response<DataResponse>



}