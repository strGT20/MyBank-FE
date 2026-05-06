package com.example.mybank.ui.components

import com.example.mybank.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mybank.ui.theme.OnyxMain
import com.example.mybank.ui.theme.PureWhite
import com.example.mybank.ui.theme.RedMain
import com.example.mybank.ui.theme.SubtleText

@Composable
fun MyBankTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPassword: Boolean = false,
    isRedMode: Boolean // True = Login (Garis Putih), False = Register (Garis Abu/Onyx)
) {
    // Menentukan warna berdasarkan parameter isRedMode
    val textColor = if (isRedMode) PureWhite else OnyxMain
    val borderColor = if (isRedMode) PureWhite else SubtleText
    val labelColor = if (isRedMode) PureWhite else SubtleText

    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp), // Bentuk membulat sesuai desain
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedBorderColor = borderColor,
            unfocusedBorderColor = borderColor,
            focusedLabelColor = labelColor,
            unfocusedLabelColor = labelColor,
            cursorColor = textColor
        ),
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(
                            id = if (passwordVisible) {
                                R.drawable.ic_eye_on20dp
                            } else {
                                R.drawable.ic_eye_off20dp
                            }
                        ),
                        contentDescription = "Toggle Password",
                        tint = textColor
                    )
                }
            }
        }
    )
}