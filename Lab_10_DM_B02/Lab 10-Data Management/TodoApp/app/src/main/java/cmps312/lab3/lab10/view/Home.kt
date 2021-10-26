package cmps312.lab3.lab10.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.viewmodel.TodoViewModel

@Composable
fun Home(onAddProject: () -> Unit, onProjectSelected: () -> Unit) {

    val todoViewModel =
        viewModel<TodoViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val projects = todoViewModel.projects.observeAsState(listOf()).value
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),


        elevation = 16.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            LazyColumn {
                items(projects) { project ->
                    ProjectCard(project, onProjectSelected = {
                        todoViewModel.selectedProject = project
                        todoViewModel.getTodos(project)
                        onProjectSelected()
                    })
                }
            }
        }
        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
            FloatingActionButton(
                onClick = { onAddProject() },
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                modifier = Modifier.size(width = 62.dp, height = 62.dp)


            ) {
                Icon(Icons.Filled.Add, "")
            }
        }

    }


}

@Composable
fun ProjectCard(project: Project, onProjectSelected: () -> Unit) {


    Card(elevation = 10.dp,
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()

            .clickable { onProjectSelected() }

    ) {
        Row(modifier = Modifier
            .padding(15.dp)


        ) {

            Column(modifier = Modifier
                .size(24.dp)
            )
            {
                Text(text = "${project.name}")

            }


        }

    }
}