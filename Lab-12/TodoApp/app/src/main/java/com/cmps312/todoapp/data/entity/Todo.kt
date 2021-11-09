package com.cmps312.todoapp.data.entity

data class Todo(
    var title: String? = "",
    var priority: String? = "",
    var date: String? = "",
    var projectId: String? = "",
    var todoId: String? = "",
){

    constructor():this(title = "",priority = "",date="",projectId = "",todoId="")
}