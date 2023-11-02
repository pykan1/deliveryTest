package com.example.delivery.screen.pizza

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyScopeMarker
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.delivery.domain.models.PizzaUI

@Composable
fun PizzaContent(modifier: Modifier) {
    val viewModel = PizzaViewModel()
    val state by viewModel.state.collectAsState()
    LaunchedEffect(viewModel) {
        viewModel.loadData()
    }

    LazyColumn(modifier = modifier) {
        items(state.pizza) {
            PizzaItem(pizzaUI = it)
        }
    }

}

@Composable
fun PizzaItem(pizzaUI: PizzaUI) {
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = pizzaUI.image,
                contentDescription = "",
                modifier = Modifier.size(135.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(start = 22.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = pizzaUI.title, style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF222831),
                    )
                )

                Text(
                    text = pizzaUI.body,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFAAAAAD),

                        )
                )

                Box(
                    modifier = Modifier
                        .width(87.dp)
                        .height(32.dp)
                ) {
                    Button(onClick = { }) {
                        Text(text = "от ${pizzaUI.minPrice} р")
                    }
                }


            }
        }
        Divider(thickness = 1.dp, color = Color(0xFFF3F5F9), modifier = Modifier.padding(top = 16.dp))
    }

}