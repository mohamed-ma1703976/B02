package cmps312.lab3.mvvmpractice.repository

import android.content.Context
import cmps312.lab3.mvvmpractice.model.Grades
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class BankRepository(private val context: Context) {

    private fun readData(filename: String) =
        context.assets.open(filename).bufferedReader().use { it.readText() }

    fun getGrades()=
        Json.decodeFromString<List<Grades>>(readData("grades.json"))
}