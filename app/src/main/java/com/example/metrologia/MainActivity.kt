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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.metrologia.ui.theme.MetrologiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MetrologiaTheme {
                FullComponent()
            }
        }
    }
}

var horizontalPadding = 15.dp

//@Preview(showBackground = true)
@Composable
fun TopBar(): Unit{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.background(color = Color.Cyan)
            .padding(horizontal = horizontalPadding, vertical = 25.dp),
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




@Preview(showBackground = true)
@Composable
fun FullComponent(): Unit {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(R.drawable._86449326_37c2256216_b),"asd",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxHeight().alpha(0.5f))
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            TopBar(

            )
            TextBlock()
            BlocoCentral()
        }


    }
    
}

@Preview
@Composable
fun TextBlock(): Unit {
    Column(
        modifier = Modifier.padding(horizontalPadding)
    ) {
        Row {
            Text("Olá")
            Spacer(modifier = Modifier.size(size = 3.dp))
            Text("Carlos", fontWeight = FontWeight.Bold,fontSize = 17.sp)
        }
            Text("17 de Outubro de 2025")

            Text(text = "Vila Franca de Xira")


    }
}
@Preview
@Composable
fun BlocoCentral (){
    Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(top = 15.dp)) {
        Box(modifier = Modifier.size(250.dp).clip(CircleShape).background(color = Color.White)){
            Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(R.drawable.sun), contentDescription = "Sol", modifier = Modifier.size(150.dp))
                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text("23º", fontWeight = FontWeight.Bold, fontSize = 50.sp)
                    Text("Limpo", modifier = Modifier.padding(top = 30.dp))
                }
            }
        }
    }

}
@Preview
@Composable
fun Previsão (){
    Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(top = 15.dp).background(color = Color.Blue)) {
    }
}
