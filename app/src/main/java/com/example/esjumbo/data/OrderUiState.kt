package com.example.esjumbo.data

data class OrderUiState(
    var nama: String="",
    var alamat: String="",
    var tlp: String= "",
    val jumlah: Int = 0,
    val rasa: String = "",
    val harga: String = ""
)
