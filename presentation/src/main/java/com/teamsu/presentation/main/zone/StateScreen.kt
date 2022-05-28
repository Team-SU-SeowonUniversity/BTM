package com.teamsu.presentation.main.zone

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.skydoves.landscapist.coil.CoilImage
import com.teamsu.presentation.R
import com.teamsu.presentation.main.zone.components.BackWard
import com.teamsu.presentation.ui.theme.BackgroundColor
import com.teamsu.presentation.ui.theme.naNumPenScript

@Preview
@Composable
fun preview() {
    StateScreen(navController = rememberNavController())
}

@Composable
fun StateScreen(navController: NavController) {
    val (imageUri, setImageUri) = remember {
        mutableStateOf<Uri?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column(
            modifier = Modifier.padding(25.dp)
        ) {
            BackWard(navController = navController)

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProfileImage(imageUri, setImageUri)

                Column(
                    modifier = Modifier
                        .height(120.dp)
                        .padding(start = 15.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "1997-12-19",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = naNumPenScript,
                        color = Color.Black
                    )

                    Text(
                        text = buildAnnotatedString {
                            append("010-8702-2174")
                            append(" ")
                            append("함건형")
                        },
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = naNumPenScript,
                        color = Color.Black
                    )
                }
            }

            Divider(
                modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
                thickness = 2.dp,
                color = Color.Black,
            )
        }
    }
}

@Composable
private fun ProfileImage(
    imageUri: Uri?,
    setImageUri: (Uri?) -> Unit
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        setImageUri(uri)
    }

    CoilImage(
        modifier = Modifier
            .size(130.dp)
            .clip(CircleShape)
            .clickable { launcher.launch("image/*") },
        imageModel = imageUri,
        error = painterResource(id = R.drawable.ic_baseline_supervised_user_circle_24)
    )
}
