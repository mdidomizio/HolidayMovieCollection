package com.example.holidaymoviecollection.ui.bundlepdpscreen

import android.app.Application
import android.os.Bundle
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.holidaymoviecollection.HolidayMovieCollectionApplication
import com.example.holidaymoviecollection.R
import com.example.holidaymoviecollection.ui.createbundle.BaseMovieCard
import com.example.holidaymoviecollection.ui.createbundle.MovieCardState
import com.example.holidaymoviecollection.ui.theme.PlusJakartaSans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BundleDetailsScreen(
    bundleId: Long,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val application = LocalContext.current.applicationContext as Application
    val repository = (application as HolidayMovieCollectionApplication).bundleRepository
    val factory = BundleDetailsViewModelFactory(
        owner = androidx.savedstate.compose.LocalSavedStateRegistryOwner.current,
        repository = repository,
        defaultArgs = Bundle().apply {
            putLong("bundleId", bundleId)
        }
    )
    val viewModel: BundleDetailsViewModel = viewModel(factory = factory)
    val bundleWithMovies = viewModel.bundle.collectAsState().value ?: return
    val movies = bundleWithMovies.movies
    val bundle = bundleWithMovies.bundle

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
                                    movies.size
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
                    state = MovieCardState.Default
                )
            }
        }

    }
}