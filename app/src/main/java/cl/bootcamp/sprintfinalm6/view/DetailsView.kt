package cl.bootcamp.sprintfinalm6.view

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import cl.bootcamp.sprintfinalm6.components.ImageComponent
import cl.bootcamp.sprintfinalm6.components.TopBarComponent
import cl.bootcamp.sprintfinalm6.ui.theme.PrimaryTextColor
import cl.bootcamp.sprintfinalm6.viewModel.MovilViewModel

@Composable
fun DetailsView(movilViewModel: MovilViewModel, navController: NavController, id: Int) {

    LaunchedEffect(Unit) {
        movilViewModel.getMovilById(id)
    }

    DisposableEffect(Unit) {
        onDispose {
            movilViewModel.cleanState()
        }
    }

    val state = movilViewModel.state
    val context = LocalContext.current
    var email = "info@novaera.cl"
    var asunto = "Consulta  ${state.name} - ${id}"
    var mensaje = """        
        Hola, me gustaría obtener más información del móvil ${state.name} 
        de código ${id}. Quedo atento a su respuesta.        
    """.trimIndent()

    Scaffold(
        topBar = {
            TopBarComponent(
                title = "${state.name}",
                showButton = true
            ) {
                navController.popBackStack()
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState(0))
        ) {

            ImageComponent(state.image)

            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider()

                Text(text = state.price.toString(), color = PrimaryTextColor)
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = state.lastPrice.toString(), color = PrimaryTextColor)
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = state.description, color = PrimaryTextColor)
                Spacer(modifier = Modifier.height(30.dp))
                var textCredit="Sólo Efectivo"
                if (state.credit) {
                    textCredit="Acepta Crédito"
                }
                Text(text = textCredit, color = PrimaryTextColor)
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_SEND)
                        val emailAddress = arrayOf(email)
                        intent.putExtra(Intent.EXTRA_EMAIL, emailAddress)
                        intent.putExtra(Intent.EXTRA_SUBJECT, asunto)
                        intent.putExtra(Intent.EXTRA_TEXT, mensaje)
                        intent.type = "message/rfc822"
                        context.startActivity(Intent.createChooser(intent, "Email"))
                    }
                ) { Text(text = "Enviar correo") }

            }



        }
    }
}