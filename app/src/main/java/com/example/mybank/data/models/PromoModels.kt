package com.example.mybank.data.models

class PromoModels {
}

data class PromoList(
    val id: String,          // Penting untuk key di LazyColumn/Row
    val title: String,
    val description: String,
    val hashtag: String,
    val imageRes: Int        // Saat ini pakai Int (R.drawable), nanti tinggal ganti String (URL)
)