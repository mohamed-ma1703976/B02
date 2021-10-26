package cmps312.lab3.lab10.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.data.local.entity.Todo
import cmps312.lab3.lab10.data.repository.TodoListRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel (appContext: Application):AndroidViewModel(appContext){


    private val todoListRepo by lazy { TodoListRepo(appContext) }


var projects :LiveData<List<Project>> =todoListRepo.getProjects()

    lateinit var todos: LiveData<List<Todo>>

    lateinit var selectedProject:Project

    fun addProject(project: Project){
        viewModelScope.launch(Dispatchers.IO) {
            todoListRepo.addProject(project)
        }

    }

    fun addTodo(todo: Todo){

        viewModelScope.launch(Dispatchers.IO) {
            todoListRepo.addTodo(todo)
        }
    }

   fun getTodos(project: Project){
       todos=todoListRepo.getProjectwithTodos(project.id)
   }

}