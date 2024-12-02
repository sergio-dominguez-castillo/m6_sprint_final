package cl.bootcamp.sprintfinalm6.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import cl.bootcamp.sprintfinalm6.ui.theme.PrimaryColor
import cl.bootcamp.sprintfinalm6.ui.theme.PrimaryTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    title: String,
    showButton: Boolean = false,
    onClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title, color = PrimaryTextColor, fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = PrimaryColor
        ),
        navigationIcon = {
            if (showButton) {
                IconButton(onClick = { onClick() }) {
                    Icon(
                        Icons.AutoMirrored.Default.ArrowBack,
                        "",
                        tint = PrimaryTextColor
                    )
                }
            }
        }
    )
}