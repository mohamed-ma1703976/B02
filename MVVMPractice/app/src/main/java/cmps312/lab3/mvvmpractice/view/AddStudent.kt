package cmps312.lab3.mvvmpractice.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cmps312.lab3.mvvmpractice.Screen
import cmps312.lab3.mvvmpractice.viewmodel.GradeViewModel

@Composable
fun Add(onAddStudent: () -> Unit) {

    val gradeViewModel =
        viewModel<GradeViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    var name by remember { mutableStateOf("") }
    var grade by remember {
        mutableStateOf("")
    }

    var expandable by remember {
        mutableStateOf(false)
    }
    var grade1 by remember {
        mutableStateOf("Select Grade")
    }

    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Add Student")
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = " Name") })

        Row(modifier = Modifier.clickable { expandable = !expandable }) {
            OutlinedTextField(
                value = grade1,
                onValueChange = {},
                enabled = false,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = ""
                    )
                })
            DropdownMenu(expanded = expandable, onDismissRequest = { expandable = false }) {
                gradeViewModel.grades.forEach { st ->
                    DropdownMenuItem(onClick = {
                        expandable = false
                       grade1 = st.toString()
                        grade = st.grade.toString()


                    }) {
                        Text(text = "$st")
                    }


                }

            }
        }


        Button(onClick = {
            gradeViewModel.setNewStudent(name,grade)
            gradeViewModel.apply {
                newStudent?.let {
                gradeViewModel.addStudent(it)
                }
            }

            onAddStudent()

        }) {
            Text(text = "Submit")
        }

    }


}