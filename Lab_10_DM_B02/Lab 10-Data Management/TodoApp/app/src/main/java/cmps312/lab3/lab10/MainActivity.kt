package cmps312.lab3.lab10

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import cmps312.lab3.lab10.ui.theme.Lab10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab10Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(context: Context) {
//    val repo = TodoListRepo(context)
//    val project = Project("Homework", 123);
//    val projects by repo.getProjects().observeAsState(listOf())
//    val composableScope = rememberCoroutineScope()
//
//    composableScope.launch {
//        repo.addProject(project)
//    }
//
//    LazyColumn {
//        items(projects) { project ->
//            Text(project.name)
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab10Theme {
        Greeting(LocalContext.current)
    }
}