package com.example.mybank.ui.screens

import android.R.attr.font
import com.example.mybank.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.mybank.ui.components.MyBankNavbar
import com.example.mybank.ui.components.ResizableCard
import com.example.mybank.ui.theme.Maroon
import com.example.mybank.ui.theme.MyBankTheme
import com.example.mybank.ui.theme.OnyxMain
import com.example.mybank.ui.theme.PureWhite
import com.example.mybank.ui.theme.RedMain
import com.example.mybank.ui.theme.SubtleBackground
import com.example.mybank.ui.theme.SubtleText

@Composable
fun HomeScreen() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  },
                shape = CircleShape,
                containerColor = Maroon,
                contentColor = PureWhite
            ) {

            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            MyBankNavbar(
                currentScreen = "Beranda",
                onTabSelected = {selectedTab ->
                    // TODO: Pindah halaman pakai Navigation
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(RedMain)
                .systemBarsPadding()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            // Header, Saldo, masuk ke background merah
            Column(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
            ) {
                // --- 1. SEARCH BAR & CS BUTTON ---
                var searchQuery by remember { mutableStateOf("") }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Search Bar Custom (Figma-Perfect)
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .height(32.dp)
                            .background(PureWhite, CircleShape)
                            .padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search), // Pastikan ada icon search merah
                            contentDescription = "Search",
                            tint = RedMain,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(modifier = Modifier.weight(1f)) {
                            if (searchQuery.isEmpty()) {
                                Text(
                                    text = "Cari fitur atau transaksi",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 12.sp,
                                    color = SubtleText
                                )
                            }
                            BasicTextField(
                                value = searchQuery,
                                onValueChange = { searchQuery = it },
                                textStyle = MaterialTheme.typography.bodySmall.copy(color = OnyxMain),
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    // Tombol Pusat Bantuan (CS)
                    Row(
                        modifier = Modifier
                            .height(32.dp)
                            .background(Maroon, CircleShape)
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cs),
                            contentDescription = "CS",
                            tint = PureWhite,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text("Pusat", style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp), color = PureWhite, lineHeight = 12.sp)
                            Text("Bantuan", style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp), color = PureWhite, lineHeight = 12.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Greeting
                Text("Selamat pagi,", style = MaterialTheme.typography.bodyMedium, color = PureWhite)
                Text("Andi Saputra", style = MaterialTheme.typography.titleMedium, color = PureWhite)

                Spacer(modifier = Modifier.height(24.dp))

                ResizableCard(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = Maroon
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 0.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "Rekening Utama",
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 12.sp,
                            color = PureWhite.copy(alpha = 0.8f) // Teks agak transparan sesuai desain
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Rp12.500.000,00",
                                style = MaterialTheme.typography.titleLarge,
                                fontSize = 20.sp,
                                color = PureWhite
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.ic_eye_on20dp), // Pastikan icon mata ada
                                contentDescription = "Toggle Saldo",
                                tint = PureWhite,
//                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                ResizableCard(
                    modifier = Modifier.height(136.dp)
                ) { }

            }

            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                color = PureWhite
            ) {
                Text("Menu Lainnya", style = MaterialTheme.typography.titleMedium, color = OnyxMain)
                Spacer(modifier = Modifier.height(16.dp))

                // Grid Menu Lainnya (Placeholder MVP)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Kartu Kredit", style = MaterialTheme.typography.labelSmall)
                    Text("Lifestyle", style = MaterialTheme.typography.labelSmall)
                    Text("Tiket", style = MaterialTheme.typography.labelSmall)
                    Text("Tarik Tunai", style = MaterialTheme.typography.labelSmall)
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text("Promo untuk Anda", style = MaterialTheme.typography.titleMedium, color = OnyxMain)
                Spacer(modifier = Modifier.height(16.dp))

                // Card Promo (Placeholder)
                Card(
                    modifier = Modifier.fillMaxWidth().height(120.dp),
                    colors = CardDefaults.cardColors(containerColor = SubtleBackground)
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Banner Promo Area", color = SubtleText)
                    }
                }

                // Spacer ekstra di bawah agar konten terakhir tidak tertutup BottomNav
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    MyBankTheme {
        HomeScreen()
    }
}