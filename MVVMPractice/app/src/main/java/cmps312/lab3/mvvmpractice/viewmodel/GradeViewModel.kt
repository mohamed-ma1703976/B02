package cmps312.lab3.mvvmpractice.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import cmps312.lab3.mvvmpractice.model.Student
import cmps312.lab3.mvvmpractice.repository.BankRepository

class GradeViewModel(appContext: Application) :AndroidViewModel(appContext){

private val gradeRepository = BankRepository(appContext)

    val grades by lazy{gradeRepository.getGrades()}

   // val students :MutableState<List<Student>> = mutableStateOf(listOf())
   val students = mutableStateListOf<Student>()

lateinit var newStudent:Student
fun setNewStudent(name:String,grade:String){
    newStudent= Student(name,grade)
}

 fun addStudent(student: Student){
students.add(student)
 }

   fun delete(student: Student){
    students.remove(student)
   }
}