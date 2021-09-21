package cmps312.lab3.stadiumapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Stadium(
    var name:String,
    var city:String,
    var status:String,
    var imageName:String,
    var seatingcapacity:Int

)
