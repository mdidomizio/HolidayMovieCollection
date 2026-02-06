package com.example.holidaymoviecollection.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.holidaymoviecollection.data.MovieBundle
import com.example.holidaymoviecollection.data.mockBundles


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onFabClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val  bundles: List<MovieBundle> = mockBundles
    val backgroundColor = colorResource(id = R.color.bg)
    val fabGradient = Brush.linearGradient(
        colors = listOf(Color(0xFF0C77C4), Color(0xFF57B7FC))
    )

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(color = backgroundColor)) {
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
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = colorResource(id = R.color.text_primary)
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = colorResource(id = R.color.outline), thickness = 1.dp)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onFabClicked,
                modifier = Modifier
                    .size(72.dp)
                    .background(fabGradient, shape = CircleShape),
                containerColor = Color.Transparent,
                contentColor = colorResource(id = R.color.text_primary)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.add_bundle_button_content_description),
                    modifier = Modifier
                        .size(32.dp)
                )
            }
        },
        containerColor = backgroundColor,
        modifier = modifier
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (bundles.isEmpty()) {
                EmptyHomeState()
            } else {
                HomeList(
                    bundles = bundles,
                    modifier = modifier
                )
            }

        }
    }

}
