package com.example.myapps.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

// Fungsi untuk melakukan panggilan telepon
fun makePhoneCall(context: Context, phoneNumber: String) {
    try {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Tidak dapat melakukan panggilan.", Toast.LENGTH_SHORT).show()
    }
}

// Fungsi untuk mengirim email
fun openEmail(context: Context, recipient: String, subject: String = "", body: String = "") {
    try {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // Hanya aplikasi email yang akan merespon
            putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Tidak ada aplikasi email terinstal.", Toast.LENGTH_SHORT).show()
    }
}

// Fungsi untuk membuka URL di browser
fun openUrl(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Tidak dapat membuka link.", Toast.LENGTH_SHORT).show()
    }
}

// Fungsi untuk membuka profil media sosial (dengan membuka URL)
fun openSocialMedia(context: Context, profileUrl: String) {
    openUrl(context, profileUrl) // Memanfaatkan fungsi openUrl
}

// Fungsi untuk membuka Google Maps dengan petunjuk arah ke koordinat tertentu (eksternal)
fun openGoogleMapsDirections(context: Context, latitude: Double, longitude: Double) {
    try {
        // Format URI untuk petunjuk arah Google Maps
        val gmmIntentUri = Uri.parse("google.navigation:q=$latitude,$longitude")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps") // Memastikan dibuka dengan aplikasi Google Maps

        if (mapIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(mapIntent)
        } else {
            // Jika aplikasi Google Maps tidak terinstal, buka via browser
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/dir/?api=1&destination=$latitude,$longitude")
            )
            context.startActivity(webIntent)
        }
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Tidak dapat membuka peta atau petunjuk arah.", Toast.LENGTH_SHORT).show()
    }
}