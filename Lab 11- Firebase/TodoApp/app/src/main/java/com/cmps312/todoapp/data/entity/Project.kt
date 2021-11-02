package com.cmps312.todoapp.data.entity

import com.google.firebase.firestore.DocumentId

data class Project(
    @DocumentId
    var id: String = "",
    var name: String? = "",
)