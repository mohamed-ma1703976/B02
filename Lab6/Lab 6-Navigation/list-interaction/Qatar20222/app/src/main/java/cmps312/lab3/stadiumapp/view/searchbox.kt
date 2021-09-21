package cmps312.lab3.stadiumapp.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Composable
fun SearchBox(searchText:String,onValueChange:(String)->Unit ){


    TextField(value = searchText, onValueChange = onValueChange,
    leadingIcon = {
        Icon(Icons.Default.Search, contentDescription = "")

    },

        trailingIcon = {

            if(searchText.isNotEmpty())
            {
                IconButton(onClick = {  onValueChange("")}) {

                    Icon(Icons.Default.Close, contentDescription = "")
                }
            }
        },
        singleLine = true, shape = RectangleShape,



        )

}




@Preview(showBackground = true)
@Composable
fun SearchBoxPreview() {
    var searchText by remember { mutableStateOf("") }
    SearchBox(searchText, onValueChange = { searchText = it})
}
























/*
@Composable
fun SearchBox(searchText: String, onValueChange:(String) ->Unit,modifier: Modifier = Modifier )
{
TextField(value = searchText, onValueChange = onValueChange,
    leadingIcon = {

        Icon(Icons.Default.Search, contentDescription ="" )
    },
    trailingIcon ={
            if(searchText.isNotEmpty()){
                
                IconButton(onClick = { onValueChange("")}) {
                    Icon(Icons.Default.Close, contentDescription ="" ) }
            }
    },

singleLine = true,shape = RectangleShape,
    colors = TextFieldDefaults.textFieldColors(
        textColor = Color.White,
        cursorColor = Color.White,
        leadingIconColor = Color.White,
        trailingIconColor = Color.White,
        backgroundColor = MaterialTheme.colors.primary
    )
)
}
@Preview(showBackground = true)
@Composable
fun SearchBoxPreview() {
    var searchText by remember { mutableStateOf("") }
    SearchBox(searchText, onValueChange = { searchText = it})
}*/
