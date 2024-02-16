package com.example.assignment02_artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    MotoList( CardList = Datasource().loadMoto() ) ;
}

@Composable
fun MotoCard(MotoList: Moto ) {
    Card(
        modifier = Modifier
            .padding(20.dp)
    ){
        Image(
            painter = painterResource(id = MotoList.imageResourceId),
            contentDescription = stringResource(id = MotoList.riderNameId ),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = stringResource(id = MotoList.riderNameId ),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MotoList( CardList: List<Moto> ) {
    LazyColumn {
        items(CardList){
                MotoList -> MotoCard( MotoList );
        }
    }
}


@Composable
fun


