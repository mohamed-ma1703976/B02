package com.cmps312.todoapp.view

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.todoapp.data.entity.Project
import com.cmps312.todoapp.utils.displayMessage
import com.cmps312.todoapp.viewmodel.TodoViewModel
import com.skydoves.landscapist.glide.GlideImage
import java.util.*

@Composable
fun ProjectScreen(onSubmit: () -> Unit) {
    val todoViewModel =
        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val context = LocalContext.current
    val pid = UUID.randomUUID()
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }
    var projectName by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("Add Project") }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val imagePicker = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri -> selectedImageUri = uri }

    if (todoViewModel.selectedProject != null) {
        title = "Edit Project"
        projectName = todoViewModel.selectedProject!!.name.toString()
    }

    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxSize(), elevation = 16.dp) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = title,
                Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp), fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = projectName,
                onValueChange = { projectName = it },
                label = { Text(text = "Project Name ") },
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp)
                    .fillMaxWidth()
            )
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                }) {
                Text(text = "Select Project Image")
            }

            Button(
                onClick = {
                    if (
                        projectName.isNotEmpty()

                    ) {
                        if (todoViewModel.selectedProject == null) {
                            val newProject = Project(pid.toString(),
                                projectName,
                                selectedImageUri.toString())
                            todoViewModel.addProject(newProject, selectedImageUri!!)
                        } else {
                            val updatedProject =
                                Project(todoViewModel.selectedProject!!.id,
                                    projectName,
                                    selectedImageUri.toString())
                            todoViewModel.updateProject(updatedProject)
                        }

                        onSubmit()
                    } else {
                        Toast.makeText(
                            context, "Please provide all the information",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(16.dp)
            ) {
                Text(text = "Submit")
            }
            GlideImage(selectedImageUri /*, modifier = Modifier.width(80.dp).height(80.dp)*/)
        }

    }
}