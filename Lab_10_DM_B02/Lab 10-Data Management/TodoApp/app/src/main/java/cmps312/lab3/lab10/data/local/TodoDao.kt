package cmps312.lab3.lab10.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.data.local.entity.Todo

@Dao
interface TodoDao{

@Query("SELECT * FROM Project")
fun getProjects():LiveData<List<Project>>

/*@Query("SELECT * FROM Todo")
fun getAllTodos():LiveData<List<Todo>>*/

@Query("SELECT * FROM Todo WHERE pid=:pid")
fun getTodoByProject(pid:Int):LiveData<List<Todo>>

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun addProject(project: Project)

@Insert(onConflict=OnConflictStrategy.REPLACE )
suspend fun addTodo(todo: Todo):Long



}