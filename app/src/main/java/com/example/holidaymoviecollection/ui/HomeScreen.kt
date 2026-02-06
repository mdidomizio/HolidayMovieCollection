package com.example.holidaymoviecollection.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.holidaymoviecollection.R
import com.example.holidaymoviecollection.ui.theme.PlusJakartaSans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val backgroundColor = colorResource(id = R.color.bg)
     Scaffold(
         topBar = {
             Column {
                 TopAppBar(
                     title = {
                         Row(
                             verticalAlignment = Alignment.CenterVertically
                         ) {
                             Text(
                                 text = stringResource(id = R.string.home_screen_title),
                                 fontFamily = PlusJakartaSans,
                                 fontWeight = FontWeight.SemiBold,
                                 fontSize = 28.sp,
                                 color = colorResource(id = R.color.text_primary),
                                 maxLines = 2,
                                 overflow = TextOverflow.Ellipsis
                             )
                         }
                     },
                     colors = TopAppBarColors(
                         containerColor = backgroundColor,
                         titleContentColor = colorResource(id = R.color.text_primary),
                         scrolledContainerColor = backgroundColor,
                         navigationIconContentColor = colorResource(id = R.color.text_primary),
                         actionIconContentColor = colorResource(id = R.color.text_primary)
                     )
                 )
                 Spacer(modifier = Modifier.height(16.dp))
                 HorizontalDivider(color = colorResource(id = R.color.outline), thickness = 1.dp)
             }
         },
         containerColor = backgroundColor,
         modifier = modifier
     ) { innerPadding ->
         Column(
             modifier = modifier.padding(innerPadding),
             verticalArrangement = Arrangement.Center
         ) {
             Box(
                 contentAlignment = Alignment.Center

             ) {
                 Column() {
                     Text(
                         text = stringResource(id = R.string.home_screen_empty_title),
                         color = colorResource(id = R.color.text_primary)
                     )
                     Spacer(modifier = Modifier.height(8.dp))
                     Text(
                         text = stringResource(id = R.string.home_screen_empty_subtitle),
                         color = colorResource(id = R.color.text_primary)
                     )

                 }
             }
         }

     }
}
