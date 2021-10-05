package cmps312.lab3.mvvmpractice.model

import kotlinx.serialization.Serializable

@Serializable
class Grades(

    var grade:String?=""
){
    override fun toString() = "$grade"
}