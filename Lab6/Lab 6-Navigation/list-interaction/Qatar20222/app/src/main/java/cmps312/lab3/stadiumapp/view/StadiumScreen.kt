package cmps312.lab3.stadiumapp.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import cmps312.lab3.stadiumapp.model.Stadium
import cmps312.lab3.stadiumapp.model.StadiumCard
import cmps312.lab3.stadiumapp.model.StadiumRepository

@Composable

fun StadiumScreen(){

    var searchText by remember { mutableStateOf("")}
    var type by remember {
        mutableStateOf("All")
    }
    var sortBy by remember {
        mutableStateOf(SortBy.STADIUM_NAME)
    }
Scaffold(

    topBar ={ TopBar(serachText = searchText, onValueChange = {searchText=it},type,
        onstadiumTypeChange={type=it}, onSortchange= {sortBy=it})
        
    }
) {
   val stadiums =  StadiumRepository.getStadiums(LocalContext.current)
    StadiumList(stadiums , searchText, type ,sortBy)
}

}

@Composable
fun StadiumList(stadium:List<Stadium>,searchText:String, stadiumstatus:String,sortBy: SortBy){




    var filteredstadium = Search(stadium, searchText , stadiumstatus )
    filteredstadium= sort(filteredstadium,sortBy)


    LazyColumn{
        items( filteredstadium){

            StadiumCard(it)
        }

    }

}

