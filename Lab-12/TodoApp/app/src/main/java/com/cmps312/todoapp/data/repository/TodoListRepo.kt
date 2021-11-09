package com.cmps312.todoapp.data.repository

import android.content.ContentValues
import android.net.Uri
import android.util.Log
import com.cmps312.todoapp.data.entity.Project
import com.cmps312.todoapp.data.entity.Todo
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import com.google.firebase.storage.ktx.storage
import java.text.SimpleDateFormat
import java.util.*


object TodoListRepo {


    val db: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

    val projectDocumentsRef by lazy { db.collection("projects") }
    val todoDocumentsRef by lazy { db.collection("todos") }

    init {
        //enable offline caching
        val settings = firestoreSettings { isPersistenceEnabled = true }
        db.firestoreSettings = settings
    }

    suspend fun getProjects(): List<Project> =
        projectDocumentsRef.get().await().toObjects(Project::class.java)

    fun addProject(project: Project) = projectDocumentsRef.add(project)
        .addOnSuccessListener {
            Log.d(ContentValues.TAG, it.toString())
        }.addOnFailureListener {
            Log.d(ContentValues.TAG, it.stackTraceToString())
        }

    suspend fun updateProject(updatedProject: Project) {
        projectDocumentsRef.document(updatedProject.id).set(updatedProject).await()
    }

    suspend fun deleteProject(project: Project) =
        projectDocumentsRef.document(project.id.toString()).delete()

    suspend fun getTodoListByProject(pid: String): List<Todo> {

        val querySnapShot = todoDocumentsRef.whereEqualTo("projectId", pid).get().await()
        val todos = mutableListOf<Todo>()
        querySnapShot.forEach {
            val todo = it.toObject(Todo::class.java)
            todo.todoId = it.id
            todos.add(todo)
        }
        return todos
    }

    fun addTodo(todo: Todo) = todoDocumentsRef.add(todo)
        .addOnSuccessListener {
            Log.d(ContentValues.TAG, it.toString())
        }.addOnFailureListener {
            Log.d(ContentValues.TAG, it.stackTraceToString())
        }

    suspend fun getTodo(id: String) =
        todoDocumentsRef.document(id).get().await().toObject(Todo::class.java)

    suspend fun uploadPhoto(photoUri: Uri): String {
        // var timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        var fileName = "IMAGE_" + "_.png"

        var storageRef = FirebaseStorage.getInstance().reference.child("images")
            .child(fileName)

        val task = storageRef.putFile(photoUri).await()
        return storageRef.downloadUrl.await().toString()

    }

}