package cmps312.lab3.stadiumapp.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cmps312.lab3.stadiumapp.Greeting
import cmps312.lab3.stadiumapp.ui.theme.Qatar2022Theme

@Composable
fun StadiumCard(stadium:Stadium){
    val context = LocalContext.current
    val image = context.resources.getIdentifier(stadium.imageName,"drawable",context.packageName)
    Card(
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp)),
        elevation = 18.dp
    ) {

        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Image(painter = painterResource(id = image) , contentDescription = "stadium pic",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(width = 130.dp, height = 130.dp)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
            
            
            
            
            )
            
            
            Column(modifier=Modifier.padding(8.dp)
                .align(alignment = Alignment.CenterVertically)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly


            ) {
                Text(text = "Name: ${stadium.name}")
                Text(text = "City: ${stadium.city}")
                Text(text ="Status: ${stadium.status}" )
                Text(text ="Capacity: ${stadium.seatingcapacity}" )

            }
        }

    }


    }




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    val stadium = Stadium(
        name="Al-Gharafa Stadium",
    city="Al-Rayyan",
    status= "Major renovation",
    imageName= "al_gharafa",
        seatingcapacity = 345
    )
    StadiumCard(stadium)
}