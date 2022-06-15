package com.nikolai.lostpetsapplication.features.authScreens.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nikolai.lostpetsapplication.R
import com.nikolai.lostpetsapplication.features.authScreens.consts.textButtonStyle
import com.nikolai.lostpetsapplication.ui.theme.LostPetsApplicationTheme

@Composable
fun AuthLoginView(
    modifier: Modifier = Modifier,
    spacing: Dp = 32.dp,
    columnBottomSpacing: Dp = 40.dp,
    buttonTopSpacing: Dp = 52.dp
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = columnBottomSpacing),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            AuthTextField(
                hint = stringResource(id = R.string.email_field_hint)
            )
            AuthTextField(
                hint = stringResource(id = R.string.password_field_hint)
            )
        }

        BluePawButton(
            title = stringResource(id = R.string.auth_selector_login_title),
            onClick = { }
        )

        TextButton(
            modifier = Modifier
                .padding(top = buttonTopSpacing),
            onClick = {}
        ) {
            Text(
                text = stringResource(id = R.string.forgot_password_title),
                style = textButtonStyle
            )
        }
    }
}

@Preview
@Composable
fun AuthLoginViewPreview() {
    LostPetsApplicationTheme {
        Surface {
            AuthLoginView(
                spacing = 32.dp
            )
        }
    }
}