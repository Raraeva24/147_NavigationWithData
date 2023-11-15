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
import com.example.esjumbo.data.SumberData.flavors
import com.example.esjumbo.ui.theme.HalamanDua
import com.example.esjumbo.ui.theme.HalamanHome
import com.example.esjumbo.ui.theme.HalamanSatu
import com.example.esjumbo.ui.theme.OrderViewModel


enum class PengelolaHalaman{
    Home,
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
                HalamanHome(oneNextButtonClicked = {navHostController.navigate(PengelolaHalaman.Rasa.name)})
            }

            composable(route = PengelolaHalaman.Rasa.name){
                val context = LocalContext.current
                HalamanSatu(
                    pilihanRasa = flavors.map { id -> context.resources.getString(id)},
                    onSelectionChanged = {viewModel.setRasa(it)},
                    onConfirmButtonClicked = {viewModel.setJumlah(it)},
                    onNextButtonClicked = {navHostController.navigate(PengelolaHalaman.Summary.name)},
                    onCancelButtonClicked = { })
            }

            composable(route = PengelolaHalaman.Summary.name){
                HalamanDua(
                    orderUiState = uiState,
                    onBackButtonClicked = {}
                )
            }
        }
    }

}