package com.nikolai.lostpetsapplication.features.authScreens.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nikolai.lostpetsapplication.R
import com.nikolai.lostpetsapplication.features.authScreens.consts.textButtonStyle
import com.nikolai.lostpetsapplication.ui.theme.LostPetsApplicationTheme


@Composable
fun AuthRegistrationView(
    modifier: Modifier = Modifier,
    spacing: Dp = 32.dp,
    columnBottomSpacing: Dp = 40.dp,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = columnBottomSpacing),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            AuthTextField(
                hint = stringResource(id = R.string.name_field_hint)
            )
            AuthTextField(
                hint = stringResource(id = R.string.email_field_hint)
            )
            AuthTextField(
                hint = stringResource(id = R.string.password_field_hint)
            )
            AuthTextField(
                hint = stringResource(id = R.string.repeat_password_field_hint)
            )
        }

        BluePawButton(
            title = stringResource(id = R.string.registration_button_title),
            onClick = { }
        )
    }
}

@Preview
@Composable
fun AuthRegistrationViewPreview() {
    LostPetsApplicationTheme {
        Surface {
            AuthRegistrationView()
        }
    }

}