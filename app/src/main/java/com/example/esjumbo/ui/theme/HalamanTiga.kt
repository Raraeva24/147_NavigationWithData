package com.example.esjumbo.ui.theme

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.esjumbo.R
import com.example.esjumbo.data.OrderUiState
import com.example.esjumbo.ui.komponen.FormatLabelHarga

@Composable
fun HalamanTiga (
    orderUiState: OrderUiState,
    onBackButtonClicked: () -> Unit,
){
    val items = listOf(
        Pair(stringResource(R.string.quantity), orderUiState.jumlah),
        Pair(stringResource(R.string.flavor), orderUiState.rasa)
    )
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ){
        Text(text = stringResource(id = R.string.nama))
        Text(text = orderUiState.nama)
        Divider()
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = stringResource(id = R.string.alamat))
        Text(text = orderUiState.alamat)
        Divider()
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = stringResource(id = R.string.tlp))
        Text(text = orderUiState.tlp)
        Divider()
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBackButtonClicked) {
            Text(text = stringResource(id = R.string.buttonback))
        }
    }
    Column (
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column (
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ){
            items.forEach { item ->
                Column {
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            FormatLabelHarga(
                subtotal = orderUiState.harga,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Row (
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_small))
        ){
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { }
            ) {
                Text(stringResource(R.string.send))
            }
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick =  onBackButtonClicked
            ) {
                Text(stringResource(R.string.cancel))
            }
        }
    }
}

@Preview
@Composable
fun HalamanTigaPreview(){
    HalamanTiga(orderUiState = OrderUiState(), onBackButtonClicked = { /*TODO*/ })
}