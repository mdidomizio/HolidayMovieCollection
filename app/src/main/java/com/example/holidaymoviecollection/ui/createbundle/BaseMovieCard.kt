package com.example.holidaymoviecollection.ui.createbundle

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.holidaymoviecollection.R
import com.example.holidaymoviecollection.data.local.entities.Movie
import com.example.holidaymoviecollection.ui.theme.PlusJakartaSans


sealed interface MovieCardState {
    data object Default: MovieCardState
    data class Selectable(val isSelected: Boolean) : MovieCardState
}
@Composable
fun BaseMovieCard(
    onCardClicked: () -> Unit,
    movie: Movie,
    state: MovieCardState,
    modifier: Modifier = Modifier
) {
    val checkboxGradient = Brush.linearGradient(
        colors = listOf(Color(0xFF0C77C4), Color(0xFF57B7FC))
    )
    Column(
        modifier = Modifier
            .padding(4.dp)
            .clickable(onClick = onCardClicked)
    ) {
        Box {
            Card (
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                modifier = Modifier.then(
                if (state is MovieCardState.Selectable && state.isSelected) {
                    Modifier.border(
                        width = 2.dp,
                        color = colorResource(id = R.color.primary_gradient_start),
                        shape = RoundedCornerShape(12.dp)
                    )
                } else Modifier
            )
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(movie.poster)
                            .memoryCacheKey(movie.poster.toString())
                            .diskCacheKey(movie.poster.toString())
                            .build(),
                        contentDescription =
                            stringResource(
                                id = R.string.movie_poster_content_description,
                                movie.title
                            ),
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    // overlay when selected
                    if ( state is MovieCardState.Selectable && state.isSelected) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0x660A131D))
                        )
                    }
                }

            }
            // checkBox for selectable
            if (state is MovieCardState.Selectable) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                        .size(28.dp)
                        .background(
                            brush = if (state.isSelected) {
                                checkboxGradient
                            } else SolidColor(Color.White),
                            shape = CircleShape
                        )
                        .border(
                            width = 1.dp,
                            color =  if (!state.isSelected) {
                                colorResource(id = R.color.primary_gradient_start)
                            } else Color.Transparent,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (state.isSelected) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription =
                                stringResource(id = R.string.movie_selected_content_description),
                            tint = Color.White,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }

        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = movie.title,
            fontFamily = PlusJakartaSans,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = colorResource(id = R.color.text_primary),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
