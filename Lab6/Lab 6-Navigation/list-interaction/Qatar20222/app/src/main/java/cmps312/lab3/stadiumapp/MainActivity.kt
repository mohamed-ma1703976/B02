package cmps312.lab3.stadiumapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import cmps312.lab3.stadiumapp.model.StadiumRepository
import cmps312.lab3.stadiumapp.ui.theme.Qatar2022Theme
import cmps312.lab3.stadiumapp.view.StadiumScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StadiumRepository.getStadiums(this).forEach { Log.d("msg",it.name )}
        setContent {
            Qatar2022Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                    StadiumScreen()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Qatar2022Theme {
        Greeting("Android")
    }
}