package com.dadadadev.login_ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dadadadev.login_ui.ui.theme.Black
import com.dadadadev.login_ui.ui.theme.focusedTextField
import com.dadadadev.login_ui.ui.theme.textFieldContainer
import com.dadadadev.login_ui.ui.theme.unfocusedTextField

@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    trailing: String,
    label: String
) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    TextField(
        modifier = modifier,
        value = "",
        onValueChange = {},
        label = {
            Text(text = label, style = MaterialTheme.typography.labelMedium, color = uiColor)
        },
        colors = TextFieldDefaults.colors(
            focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextField,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextField,
            focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer.copy(alpha = 0.6f),
            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer.copy(alpha = 0.6f)
        ),
        trailingIcon = {
            TextButton(
                modifier = Modifier.padding(end = 5.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = trailing,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                    color = uiColor
                )
            }
        }
    )
}