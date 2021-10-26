package cmps312.lab3.nav

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailScreen() {
    Card(modifier = Modifier.padding(16.dp).fillMaxWidth().fillMaxSize(), elevation = 16.dp)
    {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)


        ) {
            Text(text = "Hello! Your balance is 25000 QR")
        }


    }
}