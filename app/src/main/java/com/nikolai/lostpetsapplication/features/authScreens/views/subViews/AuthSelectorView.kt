package com.nikolai.lostpetsapplication.features.authScreens.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikolai.lostpetsapplication.R
import com.nikolai.lostpetsapplication.features.authScreens.consts.authSelectorStyle
import com.nikolai.lostpetsapplication.features.authScreens.model.AuthScreenType
import com.nikolai.lostpetsapplication.features.authScreens.model.SelectAuthScreenCallback
import com.nikolai.lostpetsapplication.ui.colors.neutralBlack
import com.nikolai.lostpetsapplication.ui.theme.LostPetsApplicationTheme

@Composable
fun AuthSelectorView(
    buttonTapCallback: SelectAuthScreenCallback,
    currentType: AuthScreenType = AuthScreenType.login
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(
                modifier = Modifier.weight(1.0f),
                onClick = { buttonTapCallback(AuthScreenType.login) }
            ) {
                AuthSelectorTitle(title = stringResource(id = R.string.auth_selector_login_title))
            }
            TextButton(
                modifier = Modifier.weight(1.0f),
                onClick = { buttonTapCallback(AuthScreenType.registration) }
            ) {
                AuthSelectorTitle(title = stringResource(id = R.string.auth_selector_register_title))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = when (currentType) {
                AuthScreenType.login -> Arrangement.Start
                AuthScreenType.registration -> Arrangement.End
            }
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.5f)
                    .height(5.dp)
                    .background(Color.Blue)
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Blue)
        )
    }
}

@Composable
fun AuthSelectorTitle(title: String) = Text(
    text = title,
    style = authSelectorStyle
)

@Preview
@Composable
fun AuthSelectorViewPreview() {
    LostPetsApplicationTheme {
        Surface {
            AuthSelectorView(
                buttonTapCallback = {}
            )
        }
    }
}