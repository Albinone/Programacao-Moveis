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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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

            // Linha com as previsões dos próximos dias
            WeatherRow(listOf(
                WeatherItemData(R.drawable.sun, "23º", "Sol"),
                WeatherItemData(R.drawable.cloudy, "18º", "Nublado"),
                WeatherItemData(R.drawable.sun, "23º", "Sol"),
                WeatherItemData(R.drawable.cloudy, "18º", "Nublado"),
                WeatherItemData(R.drawable.rainy, "16º", "Chuva"),
                WeatherItemData(R.drawable.storm, "14º", "Trovoada"),
                WeatherItemData(R.drawable.snowy, "3º", "Neve")
            ))
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
            Text("Olá", fontSize = 20.sp)
            Spacer(modifier = Modifier.size(size = 3.dp))
            Text("Carlos", fontWeight = FontWeight.Bold,fontSize = 22.sp)
        }
            Text("17 de Outubro de 2025", fontSize = 20.sp)

            Text(text = "Vila Franca de Xira", fontSize = 20.sp)


    }
}
@Preview
@Composable
fun BlocoCentral (){
    Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(top = 50.dp)) {
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

// Classe que guarda os dados de cada previsão meteorológica (ícone, temperatura e descrição)
data class WeatherItemData(val image: Int, val temp: String, val description: String)

// --- Lista horizontal com as previsões dos próximos dias ---
@Preview(showBackground = true)
@Composable
fun WeatherRow(weatherList: List<WeatherItemData> = listOf(
    WeatherItemData(R.drawable.sun, "23º", "Sol"),
    WeatherItemData(R.drawable.cloudy, "18º", "Chuva"),
    WeatherItemData(R.drawable.storm, "20º", "Nublado")
)) {
    Column(modifier = Modifier.fillMaxWidth().padding(top = 65.dp)) {
        // Título da secção
        Text("Próximos 7 dias",
            modifier = Modifier.padding(horizontalPadding),
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.DarkGray)

        // Lista que se pode deslocar horizontalmente (LazyRow)
        LazyRow (
            modifier = Modifier
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Espaço entre os itens
        ) {
            items(weatherList) { item ->
                // Para cada elemento da lista, mostra um "WeatherItem"
                WeatherItem(
                    image = item.image,
                    temp = item.temp,
                    description = item.description
                )
            }
        }
    }
}

// --- Item individual da previsão (ícone, temperatura e descrição) ---
@Preview(showBackground = true)
@Composable
fun WeatherItem(
    image: Int = R.drawable.sun,
    temp: String = "00º",
    description: String = "Limpo"
) {
    Box(
        modifier = Modifier
            .size(75.dp, 150.dp)
            .shadow(
                elevation = 10.dp, // Sombra do círculo
                shape = CircleShape,
                ambientColor = Color(0xEBFFFFFF), // branco translúcido
                spotColor = Color(0xFFFFFFFF)     // brilho suave
            )
            .clip(CircleShape)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Ícone do tempo
            Image(
                painterResource(image),
                contentDescription = description,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .size(50.dp)
            )

            // Temperatura
            Text(temp,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray)

            // Descrição (ex: "Sol", "Chuva")
            Text(description,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                color = Color.DarkGray)
        }
    }
}
