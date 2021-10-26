package cmps312.lab3.lab10.data.repository

import android.content.Context
import cmps312.lab3.lab10.data.local.TodoDatabase
import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.data.local.entity.Todo

class TodoListRepo(private val context: Context){


private val todoDao by lazy{
    TodoDatabase.getDatabase(context).todoDao()
}

    fun getProjects()=todoDao.getProjects()

    suspend fun addProject(project: Project)=todoDao.addProject(project)

    suspend fun addTodo(todo: Todo)=todoDao.addTodo(todo)

    fun getProjectwithTodos(id:Int)=todoDao.getTodoByProject(id)



}