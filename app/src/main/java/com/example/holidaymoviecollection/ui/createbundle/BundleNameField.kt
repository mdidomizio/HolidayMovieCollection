package com.example.holidaymoviecollection.ui.createbundle

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.holidaymoviecollection.R
import com.example.holidaymoviecollection.ui.theme.PlusJakartaSans

@Composable
fun BundleNameField(
    modifier: Modifier = Modifier
        .padding(vertical = 16.dp)
) {
    val charactersLimit = 40
    var bundleName by remember { mutableStateOf("") }
    Box (
        modifier = Modifier.padding(16.dp)
    ){
        OutlinedTextField(
            value = bundleName,
            onValueChange = { newValue ->
                bundleName = newValue.take(n = charactersLimit)
            },
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.bundle_name_placeholder),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = PlusJakartaSans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                )
            },
            textStyle = TextStyle(
                fontFamily = PlusJakartaSans,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                color = colorResource(id = R.color.text_primary),
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = colorResource(id = R.color.surface_input),
                focusedContainerColor = colorResource(id = R.color.surface_input),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = colorResource(id = R.color.primary_gradient_start),
                unfocusedPlaceholderColor = colorResource(id = R.color.text_placeholder),
                focusedPlaceholderColor = colorResource(id = R.color.text_placeholder),
            ),
        )
        Text(
            text = "${bundleName.length}/40",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 4.dp, bottom = 4.dp),
            fontSize = 10.sp,
            color = colorResource(id = R.color.text_placeholder)
        )
    }
}
