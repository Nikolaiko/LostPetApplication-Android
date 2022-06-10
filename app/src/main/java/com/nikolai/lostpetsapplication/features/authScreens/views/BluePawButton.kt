package com.nikolai.lostpetsapplication.features.authScreens.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikolai.lostpetsapplication.R
import com.nikolai.lostpetsapplication.features.authScreens.consts.pawButtonStyle
import com.nikolai.lostpetsapplication.model.typedefs.VoidCallback
import com.nikolai.lostpetsapplication.ui.colors.mainBlue
import com.nikolai.lostpetsapplication.ui.theme.LostPetsApplicationTheme

@Composable
fun BluePawButton(
    title: String,
    onClick: VoidCallback = {}
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = mainBlue,
            disabledBackgroundColor = Color.Gray
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            modifier = Modifier
                .padding(end = 10.dp, start = 23.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.white_paw_icon),
            contentDescription = stringResource(id = R.string.white_app_logo_desc)
        )
        Text(
            modifier = Modifier
                .padding(end = 23.dp)
                .padding(vertical = 15.dp),
            text = title,
            style = pawButtonStyle
        )
    }
}


@Preview
@Composable
fun PawButtonPreview() {
    LostPetsApplicationTheme {
        Surface {
            BluePawButton("Войти")
        }
    }
}