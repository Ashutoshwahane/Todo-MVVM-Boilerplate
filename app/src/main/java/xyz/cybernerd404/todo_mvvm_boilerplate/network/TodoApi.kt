package xyz.cybernerd404.todo_mvvm_boilerplate.network

import retrofit2.Response
import retrofit2.http.*
import xyz.cybernerd404.todo_mvvm_boilerplate.model.DataResponse
import xyz.cybernerd404.todo_mvvm_boilerplate.model.TodoEditDeleteResponse
import xyz.cybernerd404.todo_mvvm_boilerplate.model.TodoRequest
import xyz.cybernerd404.todo_mvvm_boilerplate.model.TodoResponse


/**
 * todos apis:
get all todos [GET]: /todos
get single todo [GET]: /todos/{todoId}
add todo [POST] : /todos || reqData {"todo": "TodoRequest Name", "status": true}
edit todo [PUT] : /todos/{todoId} || reqData {"todo": "TodoRequest Name", "status": true}
delete todo [DELETE]: /todos/{todoId}
toggle status [GET] : /todos/toggle/{todoId}
 * */


interface TodoApi {

    @GET("todos")
    suspend fun getTodoList(): Response<DataResponse>

    @POST("todos")
    suspend fun addTodo(@Body todoRequest: TodoRequest): Response<TodoResponse>

    @PUT("todos/{todoId}")
    suspend fun editTodo(
        @Path("todoId") todoId: String,
        @Body todoRequest: TodoRequest
    ): Response<TodoResponse>

    @DELETE("todos/{todoId}")
    suspend fun deleteTodo(@Path("todoId") todoId: String): Response<TodoEditDeleteResponse>



}