package cmps312.lab3.lab10.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey



@Entity(foreignKeys=[ForeignKey(entity = Project::class,parentColumns = ["id"],childColumns = ["pid"],onDelete = ForeignKey.CASCADE)])
data class Todo(


    var title:String?=null,
    var priority:String?=null,


    var pid:Int,

    @PrimaryKey(autoGenerate = true)
    var id:Int=0
)