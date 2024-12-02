package cl.bootcamp.sprintfinalm6.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cl.bootcamp.sprintfinalm6.ui.theme.PrimaryColor
import cl.bootcamp.sprintfinalm6.ui.theme.PrimaryTextColor

@Composable
fun CardComponent(
    name: String,
    price: Double,
    image: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onClick() }
            .shadow(10.dp),
        shape = RoundedCornerShape(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = PrimaryColor,
            contentColor = PrimaryTextColor
        )
    ) {
        Column {
            Text(text = name, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = price.toString(), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(10.dp))
            ImageComponent(image)
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

