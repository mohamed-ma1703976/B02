package cmps312.lab3.stadiumapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Modifier
import com.google.android.filament.Box


@Composable
fun Dropdown(options:List<String>,selectedOption:String, onSelectionchange:(String)->Unit){

    var expanded by remember {
        mutableStateOf(false)
    }
            Box(modifier=Modifier) {
                IconButton(onClick = { expanded = !expanded }) {
                    Row{
                        Text(selectedOption)
                        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")

                    }

                }

                DropdownMenu(expanded = expanded, onDismissRequest = {expanded=false }) {

                    options.forEach {
                            option->
                        DropdownMenuItem(onClick = { expanded=false

                            onSelectionchange(option)
                        }) {
                            Text(text=option)
                        }

                    }

                }
            }


        }



























/*
@Composable
fun Dropdown(options:List<String>, selctedOption:String, onSelectionchage:(String)->Unit,modifier: Modifier = Modifier){
var expanded by remember {
    mutableStateOf(false)

}
IconButton(onClick = { expanded = !expanded }) {
        Row{
        Text(selctedOption)
        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
    }
}
DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false }) {
options.forEach { option -> DropdownMenuItem(onClick =

{ expanded=false
    onSelectionchage(option)

}

) {
    Text(text = option)
    
} }
}
}
*/
