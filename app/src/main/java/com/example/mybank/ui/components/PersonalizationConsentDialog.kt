package com.example.mybank.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.mybank.R
import com.example.mybank.ui.theme.OnyxMain
import com.example.mybank.ui.theme.PureWhite
import com.example.mybank.ui.theme.RedMain

@Composable
fun PersonalizationConsentDialog(
    showDialog: Boolean,
    onAllow: () -> Unit,
    onDecline: () -> Unit
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = { /* Kosongkan agar tidak bisa ditutup dengan klik di luar */ },
            properties = DialogProperties(
                dismissOnBackPress = false, // Wajib dijawab
                dismissOnClickOutside = false,
                usePlatformDefaultWidth = false
            )
        ) {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = PureWhite),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Logo MyBank
                    Image(
                        painter = painterResource(id = R.drawable.ic_logo_red_main), // Pastikan nama drawable logo benar
                        contentDescription = "Logo MyBank",
                        modifier = Modifier
                            .height(64.dp)
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        contentScale = androidx.compose.ui.layout.ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    // Judul
                    Text(
                        text = "Tingkatkan Relevansi Layanan",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = OnyxMain,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Teks
                    Text(
                        text = "Kami ingin memberikan penawaran dan rekomendasi fitur yang benar-benar sesuai dengan kebutuhan finansial Anda.\n\n" +
                                "Dengan mengaktifkan fitur ini, Anda mengizinkan MyBank untuk memproses riwayat transaksi Anda menggunakan sistem AI yang aman.\n\n" +
                                "Anda memegang kendali penuh dan dapat menonaktifkannya kapan saja melalui Profil > Pengaturan > Personalisasi AI.",
                        style = MaterialTheme.typography.bodySmall,
                        color = OnyxMain,
                        lineHeight = 20.sp // Memberi ruang antar baris agar lebih enak dibaca
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    // Tombol IZINKAN
                    Button(
                        onClick = onAllow,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = RedMain),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "Izinkan",
                            style = MaterialTheme.typography.labelLarge,
                            color = PureWhite
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Tombol TOLAK
                    OutlinedButton(
                        onClick = onDecline,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = RedMain),
                        border = androidx.compose.foundation.BorderStroke(1.dp, RedMain),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "Tolak",
                            style = MaterialTheme.typography.labelLarge,
                            color = RedMain
                        )
                    }
                }
            }
        }
    }
}