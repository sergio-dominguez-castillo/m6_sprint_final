package cl.bootcamp.sprintfinalm6.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImageComponent(image: String) {
    val image = rememberAsyncImagePainter(model = image)

    Image(
        painter = image,
        contentDescription = "Imagen del Movil",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    )
}