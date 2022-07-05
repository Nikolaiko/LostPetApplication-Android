package com.nikolai.lostpetsapplication.features.authScreens.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import javax.annotation.Untainted

@Composable
fun AuthTextField(
    onChange: (String) -> Unit = { },
    currentValue: String = "",
    hint: String = ""
) {
    Column {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 15.dp
        ) {
            TextField(
                value = currentValue,
                onValueChange = onChange,
                placeholder = {
                    Text(text = hint)
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
        Text(text = "Error text")
    }

}

@Preview
@Composable
fun AuthTextFieldPreview() {
    AuthTextField()
}