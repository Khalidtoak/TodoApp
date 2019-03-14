package khalid.com.todoapp.database

import androidx.room.*

/**
 * Created by ${KhalidToak} on 3/8/2019.
 * The dao is the class that gives us access to the Entity
 * here we create functions to insert, update and delete todos
 */
@Dao
interface TodoDao {
    @Insert
    fun insertTodo(todoEntity: TodoEntity)
    @Delete
    fun deleteTodo(todoEntity: TodoEntity)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTodo(todoEntity: TodoEntity)

    @Query("SELECT * FROM todo")
    fun getAllTodos() : List<TodoEntity>

    @Query("SELECT * FROM todo WHERE id = :id")
    fun getOneTodo(id : Int) : TodoEntity

}