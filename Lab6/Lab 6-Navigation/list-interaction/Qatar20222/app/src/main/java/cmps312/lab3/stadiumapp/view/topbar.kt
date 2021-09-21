package cmps312.lab3.stadiumapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import cmps312.lab3.stadiumapp.model.Stadium



enum class SortBy{SEATING_CAPACITY, STADIUM_NAME,CITY_NAME}
@Composable
fun TopBar(serachText:String,onValueChange:(String) ->Unit,stadiumtype:String,onstadiumTypeChange:(String)->Unit,
onSortchange: (SortBy) -> Unit)
{ val type = listOf("All",
        "To be built",
        "Major renovation")
TopAppBar(title = { Text(text = "")}, actions = {

SearchBox(searchText = serachText, onValueChange =onValueChange )
    Dropdown(options = type, selectedOption =stadiumtype , onSelectionchange = onstadiumTypeChange)
    Sort(onSortchange )
})

}

@Composable
fun Sort(onSortchange: (SortBy) -> Unit){
var expanded by remember { mutableStateOf(false) }

    val sortoptions = mapOf("sort by seating capacity" to SortBy.SEATING_CAPACITY,

                            "sort by stadium name" to SortBy.STADIUM_NAME,
                            "sort by city name " to SortBy.CITY_NAME
        )
    Box(modifier= Modifier) {
        IconButton(onClick = { expanded= true }) {
            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "")

        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false }) {
            sortoptions.forEach { option -> DropdownMenuItem(onClick =

            { expanded=false
                onSortchange(option.value)
            }

            ) {
                Text( option.key)
            } }
        }
    }

}
fun Search(stadium:List<Stadium>, searchText:String, type:String)=

    if(searchText.isNullOrEmpty() &&type=="All"){
        stadium
    }
    else{

        stadium.filter {
            ( it.city.contains(searchText,ignoreCase = true) ||   //ignore character case
                    it.name.contains(searchText,ignoreCase = true )||
                    searchText.isNullOrEmpty())
                    && (it.status==type || type =="All")

        }
    }

fun sort(stadium: List<Stadium>, sortBy: SortBy) =
    when (sortBy) {
        SortBy.SEATING_CAPACITY -> stadium.sortedBy { it.seatingcapacity }
        SortBy.CITY_NAME -> stadium.sortedBy{it.city}
        SortBy.STADIUM_NAME-> stadium.sortedBy{it.name}


    }
