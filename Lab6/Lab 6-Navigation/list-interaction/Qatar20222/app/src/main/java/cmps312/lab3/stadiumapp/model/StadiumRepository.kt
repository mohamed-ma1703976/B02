package cmps312.lab3.stadiumapp.model

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object StadiumRepository {

    var stadiums = listOf<Stadium>()

    fun getStadiums(context: Context):List<Stadium>{
        if (stadiums.isEmpty()) {
            val stadiumJson =
                context.assets.open("stadiums.json").bufferedReader().use { it.readText() }

            stadiums = Json.decodeFromString(stadiumJson)
        }

        return stadiums
    }



}
