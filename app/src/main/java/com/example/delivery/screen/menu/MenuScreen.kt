package com.example.delivery.screen.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.delivery.R
import com.example.delivery.domain.models.MenuTabs
import com.example.delivery.domain.models.getText
import com.example.delivery.screen.pizza.PizzaContent
import com.example.delivery.screen.uiKit.DeliveryPageContainer
import org.koin.androidx.compose.koinViewModel

class MenuScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<MenuViewModel>()
        LaunchedEffect(viewModel) {
            viewModel.loadData()
        }
        DeliveryPageContainer(background = Color(0xFFFBFBFB), header = {
            Row {
                Text(text = "header")
            }
        }, content = {
            MenuContent(viewModel)
        })
    }

    @Composable
    fun MenuContent(viewModel: MenuViewModel) {
        val state by viewModel.state.collectAsState()
        Column(modifier = Modifier.fillMaxWidth()) {

            LazyRow(
                modifier = Modifier,
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.sale),
                        contentDescription = "",
                        modifier = Modifier.size(width = 300.dp, height = 112.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                item {
                    Image(
                        painter = painterResource(id = R.drawable.sale2),
                        contentDescription = "",
                        modifier = Modifier.size(width = 300.dp, height = 112.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }


            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(state.tabs) { tab ->
                    MenuTab(
                        selected = state.currentTab == tab,
                        tab = tab,
                        onClick = { viewModel.changeCurrentState(it) })
                }
            }
            Divider(
                thickness = 1.dp,
                color = Color(0xFFF3F5F9),
                modifier = Modifier.padding(top = 16.dp)
            )
            when (state.currentTab) {
                MenuTabs.Pizza -> {
                    PizzaContent(modifier = Modifier.padding(16.dp))
                }

                MenuTabs.Combo -> {}
                MenuTabs.Desserts -> {}
                MenuTabs.Drinks -> {}

            }
        }


    }

    @Composable
    private fun MenuTab(selected: Boolean, tab: MenuTabs, onClick: (MenuTabs) -> Unit) {
        Box(
            modifier = Modifier
                .heightIn(min = 32.dp)
                .widthIn(min = 88.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(if (selected) Color(0x33FD3A69) else Color.White)
                .clickable { onClick(tab) }
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color(0x2BBEBEBE),
                    ambientColor = Color(0x2BBEBEBE)
                )
        ) {
            Text(
                text = tab.getText(),
                modifier = Modifier.align(Alignment.Center),
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = if (selected) FontWeight(600) else FontWeight(400),
                    color = if (selected) Color(0xFFFD3A69) else Color(0xFFC3C4C9),
                )
            )
        }
    }

}