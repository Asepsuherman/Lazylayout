package id.utdi.asepsuherman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
//import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.utdi.asepsuherman.ui.theme.LazylayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazylayoutTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyLayoutDemo()
                }
            }
        }
    }
}

data class Item(val name: String, val description: String, val imageRes: Int, val tipe: String)

@Composable
fun LazyLayoutDemo() {
    val brands = listOf("Nasa", "Nike", "Adidas", "Puma", "Lacoste", "Stone Island", "CP Company" )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(brands) { brand ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { /* Handle brand click here */ },
                ) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = brand,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxSize(),
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        val items = remember {
            listOf(
                Item("NASA ", "Blouson militer NASA dalam warna abu-abu dan ukuran 4XL adalah pilihan pakaian yang modis dan terinspirasi dari eksplorasi luar angkasa. Blouson ini dengan bangga menampilkan lambang NASA, memberikan sentuhan gaya futuristik. Dirancang untuk kenyamanan maksimal dan terbuat dari bahan berkualitas tinggi, cocok untuk pecinta mode dan petualangan. Pakaian serbaguna ini sempurna untuk hari-hari yang sejuk dan merupakan penghormatan terhadap eksplorasi luar angkasa.", R.drawable.blouson_militaire_de_la_nasa___gris___4xl_removebg_preview, "- Blouson Militaire Jacket"),
                Item("NASA ", "Jaket NASA tipe Japanese Embroidered Jacket adalah gabungan sempurna antara gaya dan semangat eksplorasi luar angkasa. Jaket ini menampilkan bordiran unik dengan desain ala Jepang yang menarik perhatian. Lambang NASA yang terkenal memberikan sentuhan futuristik. Terbuat dari bahan berkualitas tinggi, jaket ini nyaman dipakai sepanjang tahun. Cocok untuk penggemar NASA dan pecinta fashion yang ingin tampil unik dan bersemangat. Jaket ini menggabungkan gaya dan semangat penjelajahan dengan sempurna.", R.drawable.japanese_embroidered_jacket_removebg_preview, "- Japannese Embroidered Jacket"),
                Item("NASA ", "Men Jacket New Fashion Casual Coat Solid Pilot Bomber Jacket dalam warna abu-abu dan ukuran USA M adalah pilihan yang stylish untuk penampilan kasual pria. Desain pilot bomber memberikan sentuhan klasik, sementara bahan berkualitas tinggi memberikan kenyamanan dan tahan lama. Jaket ini cocok untuk berbagai kesempatan dan cuaca. Dengan gaya yang trendi dan ukuran yang sesuai, ini adalah pilihan sempurna untuk penampilan pria yang modern.", R.drawable.men_jacket_new_fashion_casual_men_coat_solid_pilot_bomber_jacket___gray___usa_m_removebg_preview, "- Casual Bomber Jacket"),
                Item("NASA ", "Men Jacket New Fashion Casual Coat Solid Pilot Bomber Jacket dalam warna abu-abu dan ukuran USA M adalah pilihan yang stylish untuk penampilan kasual pria. Desain pilot bomber memberikan sentuhan klasik, sementara bahan berkualitas tinggi memberikan kenyamanan dan tahan lama. Jaket ini cocok untuk berbagai kesempatan dan cuaca. Dengan gaya yang trendi dan ukuran yang sesuai, ini adalah pilihan sempurna untuk penampilan pria yang modern.", R.drawable.plus_size_casual_flight_jacket_men___navy_blue___3xl_removebg_preview, "- Casual Flight Jacket"),
            )
        }


        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(items) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.background)
                        .padding(8.dp)
                        .clickable { /* Handle card click here */ },
                    shape = MaterialTheme.shapes.medium, // Optional: Add rounded corners

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = item.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                        Text(
//                        text = item.name,
//                        style = MaterialTheme.typography.bodyLarge
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append(item.name)
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                append(item.tipe)
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = item.description,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazylayoutTheme {
        LazyLayoutDemo()
    }
}