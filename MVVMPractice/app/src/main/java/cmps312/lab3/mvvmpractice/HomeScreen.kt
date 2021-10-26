package cmps312.lab3.mvvmpractice

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen(){


val navHostController = rememberNavController()
Scaffold(topBar = {TopBar()}) {
    AppNavHost(navHostController )
}  

}
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(text = "Add Student")
        },
        //Provide the navigation Icon ( Icon on the left to toggle drawer)

    )
}