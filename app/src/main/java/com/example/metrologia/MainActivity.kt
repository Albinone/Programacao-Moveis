package com.example.metrologia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.metrologia.ui.theme.MetrologiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MetrologiaTheme {
                TopBar()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBar(): Unit{
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 25.dp ),
                horizontalArrangement = Arrangement.SpaceBetween
    ){
        Box(
            modifier = Modifier
                    .size(size = 52.dp)
                    .clip(CircleShape)
                .background(Color.White)
                .padding(10.dp)


        ){
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search",

                )



        }

        Image(
                painter = painterResource(id = R.drawable.foto),
                contentDescription = "Foto",
                modifier = Modifier
                    .size(size = 52.dp)
                    .clip(CircleShape)
        )


    }
}


