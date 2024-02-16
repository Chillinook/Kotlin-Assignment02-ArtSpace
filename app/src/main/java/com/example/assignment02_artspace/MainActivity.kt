package com.example.assignment02_artspace

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment02_artspace.data.Datasource
import com.example.assignment02_artspace.model.Moto
import com.example.assignment02_artspace.ui.theme.Assignment02_ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment02_ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MotoSpaceApp()
                }
            }
        }
    }
}

@Composable
fun MotoSpaceApp() {
//    MotoList( CardList = Datasource().loadMoto() ) ;
    MotoSpace( CardList = Datasource().loadMoto() ) ;
}
@Composable
fun MotoSpace( CardList: List<Moto>){
    var motoNum by remember { mutableStateOf(0) }

    Column {
        Row (
            modifier = Modifier
                .padding(50.dp)
        ){//
            Image(
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .border(20.dp, Color.White)
                    .size(width = 340.dp, height = 400.dp),
                painter = painterResource(id = CardList[motoNum].imageResourceId),
                contentDescription = stringResource(id = R.string.riderDate5)
            )
        }
        Row (
            modifier = Modifier
                .padding(20.dp)
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color(0xFFD6F1F2))
                    .fillMaxWidth()
                    .fillMaxHeight(0.60f)
                    .padding(10.dp)
            ) {
                Text(
                    text = stringResource(id = CardList[motoNum].riderNameId ),
                    fontSize = 30.sp
                )
                Text(
                    text = stringResource(id = CardList[motoNum].riderDateId ),
                    fontSize = 20.sp
                )
            }
        }
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ){
            Button(
                modifier = Modifier
                    .size(height = 35.dp , width = 140.dp ),
                onClick = {
                    if (motoNum < CardList.size)
                        motoNum--
                    if (motoNum < 0 )
                        motoNum = 0
                })
                {
                Text(text = "Previous")
            }
            Button(
                modifier = Modifier
                    .size(height = 35.dp , width = 140.dp ),
                onClick = {
                    if (motoNum < CardList.size)
                        motoNum++
                    if (motoNum == CardList.size )
                        motoNum = 0
                })
               {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MotoSpaceApp()
}