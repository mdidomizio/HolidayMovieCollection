package com.example.holidaymoviecollection.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.holidaymoviecollection.data.MovieBundle

@Composable
fun HomeList(
    bundles: List<MovieBundle>,
    modifier: Modifier
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(bundles){ bundle ->
            MovieBundleItem(bundle = bundle)
        }
    }
}