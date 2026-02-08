package com.example.holidaymoviecollection.ui.createbundle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.holidaymoviecollection.R
import com.example.holidaymoviecollection.ui.theme.PlusJakartaSans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateBundleScreen(
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = colorResource(id = R.color.bg)
    val selectedMovie = emptyList<Any>()


    Scaffold(
        topBar = {
            Column (modifier = Modifier
                .background(backgroundColor)
                .padding(horizontal = 16.dp)
            ) {
                CenterAlignedTopAppBar(
                    modifier = Modifier
                        .windowInsetsPadding(WindowInsets.statusBars)
                        .padding(top = 16.dp),

                    title = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(id = R.string.create_bundle_screen_title),
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Medium,
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.text_primary),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = stringResource(
                                    id = R.string.create_bundle_screen_subtitle,
                                    selectedMovie.size
                                ),
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.text_secondary),
                                textAlign = TextAlign.Center
                            )
                        }
                    },

                    navigationIcon = {
                        IconButton(
                            onClick = onBackClicked,
                            modifier = Modifier.size(44.dp),
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = colorResource(id = R.color.surface_input),
                                contentColor = Color.White
                            )
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(id = R.string.back_button_content_description),
                                modifier = Modifier.size(20.dp),
                                tint = colorResource(id = R.color.text_secondary)
                            )
                        }
                    },

                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Transparent
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
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            BundleNameField()

/*            Spacer(modifier = Modifier.height(16.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(innerPadding),
                contentPadding = PaddingValues(8.dp),
            ) {
                items(Movie.entries){ movie ->
                    MovieCard(
                        movie = movie,
                        onCardClicked = {}
                    )

                }
            }*/
        }

    }
}
