package cmps312.lab.todoapplication.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation
import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.data.local.entity.Todo


data class ProjectWithTodos(
    @Embedded val project:Project,
    @Relation(
        parentColumn = "id",
        entityColumn ="pid"

    )

    val todos:List<Todo>

)