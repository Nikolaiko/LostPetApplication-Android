package com.nikolai.lostpetsapplication.features.authScreens.views

import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nikolai.lostpetsapplication.R
import com.nikolai.lostpetsapplication.features.authScreens.consts.*
import com.nikolai.lostpetsapplication.features.authScreens.model.AuthScreenType
import com.nikolai.lostpetsapplication.features.authScreens.viewModel.AuthScreenViewModel
import com.nikolai.lostpetsapplication.features.authScreens.views.subViews.AuthLoginView

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AuthScreenView(
    viewModel: AuthScreenViewModel
) {
    val screenType = viewModel.state.selectedType.observeAsState(AuthScreenType.login)
    val loginValue = viewModel.state.loginValue.observeAsState("")
    val loginPasswordValue = viewModel.state.loginPasswordValue.observeAsState("")

    BoxWithConstraints {
        val viewHeight = maxHeight
        val viewWidth = maxWidth

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .padding(top = viewHeight.times(topPaddingLogoCoff))
                    .padding(bottom = viewHeight.times(bottomPaddingLogoCoff)),
                painter = painterResource(id = R.drawable.app_logo_svg),
                contentDescription = stringResource(id = R.string.app_logo_desc)
            )
            Crossfade(targetState = screenType.value) { screenType ->
                AuthSelectorView(
                    buttonTapCallback = viewModel::setAuthScreenType,
                    currentType = screenType
                )
            }
            when(screenType.value) {
                AuthScreenType.login -> AuthLoginView(
                    modifier = Modifier
                        .padding(top = viewHeight.times(authFormTopPaddingCoff)),
                    spacing = viewHeight.times(elementsSpacingCoff),
                    columnBottomSpacing = viewHeight.times(elementsColumnBottomCoff),
                    buttonTopSpacing = viewHeight.times(bottomButtonTopCoff),
                    loginValue = loginValue.value,
                    loginChangeCallback = viewModel::onLoginEmailChange,
                    passwordValue = loginPasswordValue.value,
                    passwordChangeCallback = viewModel::onLoginPasswordChange,
                    loginCallback = viewModel::tryToLogin
                )
                AuthScreenType.registration -> AuthRegistrationView(
                    modifier = Modifier
                        .padding(top = viewHeight.times(authFormTopPaddingCoff)),
                    spacing = viewHeight.times(elementsSpacingCoff),
                    columnBottomSpacing = viewHeight.times(elementsColumnBottomCoff),
                    loginValue = viewModel.registerEmail,
                    loginChangeCallback = viewModel::onRegisterEmailChange,
                    passwordValue = viewModel.registerPassword,
                    passwordChangeCallback = viewModel::onRegisterPasswordChange,
                    nameValue = viewModel.registerName,
                    nameChangeCallback = viewModel::onRegisterNameChange,
                    passwordConfirmValue = viewModel.registerConfirmPassword,
                    passwordConfirmChangeCallback = viewModel::onRegisterPasswordConfirmChange
                )
            }

            Spacer(modifier = Modifier.weight(1.0f))
            TextButton(
                onClick = {}
            ) {
                Text(
                    text = stringResource(id = R.string.later_login_title),
                    style = textButtonStyle
                )
            }
            Spacer(
                modifier = Modifier.requiredHeight(
                    viewHeight.times(laterLoginTopPaddingCoff)
                )
            )
        }
    }
}

//@Preview
//@Composable
//fun AuthScreenPreview() {
//    LostPetsApplicationTheme {
//        Surface {
//            val model = AuthScreenViewModel()
//
//            AuthScreenView(
//                viewModel = model
//            )
//        }
//    }
//
//}