package com.example.basiclayoutsincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiclayoutsincompose.ui.theme.BasicLayoutsInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicLayoutsInComposeTheme {
show()
            }
        }
    }
}
@Preview
@Composable
fun searchBar(modifier: Modifier=Modifier){
    TextField(value = "", onValueChange = {},
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text(text = "Search")
        },
        modifier = Modifier
            .heightIn(min = 65.dp)
            .padding(8.dp)
            .fillMaxWidth())
}

@Preview
@Composable
fun new(modifier: Modifier = Modifier) {
    TextField(value = "", onValueChange = {},
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text(text = "search")
        },
        modifier = Modifier
            .heightIn(min = 65.dp)
            .padding(8.dp)
            .fillMaxWidth())
}

@Composable
fun AlignYourBodyElement(modifier: Modifier = Modifier, drawable: Int, text: String){
  
Column(modifier.background(Color.Gray)) {
    Image(painter = painterResource(id = R.drawable.yoga1),
        contentDescription =null ,
        modifier
            .size(88.dp)
            .clip(CircleShape),

    //for making image round we make content parameter crop by contentScale function
        contentScale = ContentScale.Crop)
    Text(text = "Inversions", style = MaterialTheme.typography.bodyMedium
        ,modifier = Modifier
            .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
            .padding(start = 8.dp))
}


}
@Preview
@Composable
fun favoriteCollectionCard(modifier: Modifier=Modifier){
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier)
     {
        Row(
            modifier
                .width(192.dp)
                .height(200.dp),verticalAlignment = Alignment.CenterVertically) {
Image(painter = painterResource(id = R.drawable.yoga2) , contentDescription =null , modifier = Modifier.size(56.dp))
            Text(text = "Nature meditations", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(horizontal = 16.dp))
        }

    }
}
//for scrollable views we have lazyRow and lazyColumn
@Preview
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(modifier = Modifier.background(Color.Gray),
        //instead of padding we use contentPadding that gives padding to the content and normal padding function gives padding to the parent composable

        contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(
                drawable = item,
                text ="Inversions" // You need to provide a text value here
            )
        }
    }
}

private val alignYourBodyData = listOf(
    R.drawable.yoga1,
    R.drawable.yoga1,
    R.drawable.yoga1,
    R.drawable.yoga1,
    R.drawable.yoga1,
    R.drawable.yoga1,
    R.drawable.yoga1,
    R.drawable.yoga1
)
@Preview
@Composable
fun FavoriteCollectionsGrid( ) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = Modifier
            .height(150.dp)
            .background(Color.Gray),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(favoriteCollectionCard) { item ->
            FavoriteCollectionCard(
                drawable = item,
                text = "Inversions"
            )
        }
    }
}

private val favoriteCollectionCard = listOf(
    R.drawable.yoga2,
    R.drawable.yoga2,
    R.drawable.yoga2,
    R.drawable.yoga2,
    R.drawable.yoga2,
    R.drawable.yoga2,
    R.drawable.yoga2,
    R.drawable.yoga2
)

@Composable
fun FavoriteCollectionCard(
    drawable: Int,
    text: String
) {
    // Your composable
// function implementation here
    favoriteCollectionCard()
}
@Preview
@Composable
fun show(){
Column(modifier = Modifier
    .fillMaxSize()
    .background(Color.Gray))  {
    searchBar()
    Column(Modifier.padding(top = 25.dp)) {
        Text(text = "Align your Body", modifier = Modifier.padding(16.dp), fontSize = 20.sp)


        AlignYourBodyRow()
    }
    Column(modifier = Modifier.padding(vertical = 40.dp)) {
        Text(text = "New Collections", modifier = Modifier.padding(16.dp), fontSize = 20.sp)
        FavoriteCollectionsGrid()
        Text(text = "Favorite Collections", modifier = Modifier.padding(16.dp), fontSize = 20.sp)
        FavoriteCollectionsGrid()
    }



}
}






