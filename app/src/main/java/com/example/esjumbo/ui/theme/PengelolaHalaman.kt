@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.esjumbo.ui.theme.HalamanHome
import com.example.esjumbo.ui.theme.OrderViewModel
import com.example.praktikum10november.ui.layout.HalamanSatu


enum class PengelolaHalaman{
    Home,
    Fomulir,
    Rasa,
    Summary
}


@Composable
fun EsJumboApp(
    viewModel: OrderViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController()
){
    Scaffold {innerpadding ->
        val uiState by viewModel.stateUI.collectAsState()

        NavHost(
            navController = navHostController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerpadding)
        ){
            composable(route = PengelolaHalaman.Home.name){
                HalamanHome(oneNextButtonClicked = {navHostController.navigate(PengelolaHalaman.Fomulir.name)})
            }

            composable(route = PengelolaHalaman.Fomulir.name){
                HalamanSatu(onSubmitButtonClicked = {viewModel.setContact(it)})
            }
        }
    }

}