package com.example.holidaymoviecollection.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.holidaymoviecollection.R
import com.example.holidaymoviecollection.data.MovieBundle
import com.example.holidaymoviecollection.ui.theme.PlusJakartaSans
import java.util.Locale.getDefault

@Composable
fun MovieBundleItem(
    bundle: MovieBundle
) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(R.drawable.folder_icon),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(56.dp, 47.dp)
            )
            Text(
                text = bundle.name.first().toString().uppercase(getDefault()),
                fontSize = 22.sp,
                fontFamily = PlusJakartaSans,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.text_placeholder)
            )

        }

        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(
                text = bundle.name,
                fontSize = 18.sp,
                fontFamily = PlusJakartaSans,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.bundle_item_subtitle, bundle.movies.size),
                fontSize = 14.sp,
                fontFamily = PlusJakartaSans,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }
    }
}
