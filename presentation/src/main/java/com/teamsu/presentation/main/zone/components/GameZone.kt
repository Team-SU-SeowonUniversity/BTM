package com.teamsu.presentation.main.zone.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.teamsu.presentation.R
import com.teamsu.presentation.ui.theme.BackgroundColor
import com.teamsu.presentation.ui.theme.songMyung

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameZoneScreen(
    zoneName: String,
    navController: NavController,
    gameName: List<String>,
    gameThumbnail: List<Painter>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            IconButton(
                onClick = { navController.navigateUp() }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "back button"
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text =  zoneName,
                color = Color.White,
                fontSize = 30.sp,
                fontFamily = songMyung,
                fontWeight = FontWeight.Normal,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            thickness = 2.dp,
            color = Color.Black,
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 15.dp, end = 15.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(gameName.size) { index ->
                GameCard(
                    image = gameThumbnail[index],
                    textValue = gameName[index]
                )
            }
        }
    }
}
