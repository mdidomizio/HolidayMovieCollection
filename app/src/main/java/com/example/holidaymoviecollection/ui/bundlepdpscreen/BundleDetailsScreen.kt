package com.example.holidaymoviecollection.ui.bundlepdpscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.holidaymoviecollection.R
import com.example.holidaymoviecollection.data.local.entities.Movie
import com.example.holidaymoviecollection.data.MovieBundle
import com.example.holidaymoviecollection.ui.createbundle.BaseMovieCard
import com.example.holidaymoviecollection.ui.createbundle.MovieCardState
import com.example.holidaymoviecollection.ui.theme.PlusJakartaSans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BundleDetailsScreen(
    onBackClicked: () -> Unit,
    bundle: MovieBundle,
    modifier: Modifier = Modifier
) {
    val movies: List<Movie> = bundle.movies

    val backgroundColor = colorResource(id = R.color.bg)
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
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
                                text = bundle.name,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Medium,
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.text_primary),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = stringResource(
                                    id = R.string.bundle_details_screen_movie_count,
                                    bundle.movies.size
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

                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = colorResource(id = R.color.outline), thickness = 1.dp)
            }
        },
        containerColor = backgroundColor,
        modifier = Modifier
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            items(movies) { movie ->
                BaseMovieCard(
                    movie = movie,
                    onCardClicked = {},
                    state = MovieCardState.Default,
                    modifier = modifier
                )
            }
        }

    }
}
