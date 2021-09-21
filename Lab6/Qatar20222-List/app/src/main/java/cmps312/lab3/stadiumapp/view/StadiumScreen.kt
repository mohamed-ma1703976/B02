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


   val stadiums =  StadiumRepository.getStadiums(LocalContext.current)
    StadiumList(stadiums )
}



@Composable
fun StadiumList(stadium:List<Stadium>){







    LazyColumn{
        items( stadium){

            StadiumCard(it)
        }

    }

}

