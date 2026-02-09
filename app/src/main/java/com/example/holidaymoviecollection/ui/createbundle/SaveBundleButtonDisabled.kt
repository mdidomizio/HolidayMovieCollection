package com.example.holidaymoviecollection.ui.createbundle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.holidaymoviecollection.R
import com.example.holidaymoviecollection.ui.theme.PlusJakartaSans

@Composable
fun SaveBundleButtonDisabled (
    modifier: Modifier = Modifier,
){
    Box(modifier = modifier.fillMaxSize()) {
        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 36.dp, vertical = 24.dp)
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.surface_disabled),
                    shape = RoundedCornerShape(100.dp),
                ),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = colorResource(id = R.color.surface_disabled),
                disabledContentColor = colorResource(id = R.color.text_placeholder),
                containerColor = Color.Transparent,
                contentColor = Color.White
            )

        ) {
            Text(
                text = stringResource(id = R.string.create_bundle_save_button_text),
                fontFamily = PlusJakartaSans,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = colorResource(id = R.color.text_placeholder),
            )
        }
    }
}
