package com.example.myapps.utils

import com.example.myapps.R
import com.example.myapps.data.models.DailyActivity
import com.example.myapps.data.models.Friend
import com.example.myapps.data.models.GalleryItem
import com.example.myapps.data.models.Interest
import com.example.myapps.data.models.MusicItem
import com.example.myapps.data.models.UserProfile
import com.example.myapps.data.models.VideoItem
import com.example.myapps.ui.adapter.WalkthroughPage

object DummyData {

    fun getUserProfile(): UserProfile {
        return UserProfile(
            id = 1,
            name = "Dani Herawan",
            photoUrl = "profile",
            description = "Seorang mahasiswa aktif di salah satu universitas di Bandung, dengan ketertarikan mendalam pada pengembangan aplikasi mobile, khususnya Android. Saya suka belajar hal baru, berkolaborasi dalam proyek tim, dan memecahkan masalah kompleks. Di waktu luang, saya menikmati bermain game, membaca novel fiksi ilmiah, dan mencoba resep masakan baru. Cita-cita saya adalah menjadi seorang Software Architect yang inovatif dan memberikan dampak positif bagi banyak orang melalui teknologi.",
            profession = "Mahasiswa Informatika | Android Developer",
            quote = "“Saya tidak akan melakukan sesuatu yang tidak perlu.Tapi jika saya akan melakukan sesuatu, akan saya lakukan dengan cepat”"
        )
    }

    fun getDailyActivities(): List<DailyActivity> {
        return listOf(
            DailyActivity(title = "Kelas Pagi", time = "07:00 - 09:00", description = "Mengikuti mata kuliah Pemrograman Android.", imageUrl = "ic_shool_black"),
            DailyActivity(title = "Latihan Coding Mandiri", time = "11:30 - 13:00", description = "Mengerjakan studi kasus Android.", imageUrl = "ic_music_placeholder"),
            DailyActivity(title = "Makan Siang", time = "13:00 - 14:00", description = "Istirahat sambil menikmati makanan favorit.", imageUrl = "ic_home.png"),
            DailyActivity(title = "Diskusi Kelompok Tugas Besar", time = "14:00 - 16:00", description = "Merencanakan arsitektur proyek bersama tim.", imageUrl = "ic_facebook_black_24dp.png"),
            DailyActivity(title = "Olahraga & Refreshing", time = "16:00 - 18:00", description = "Jogging santai di sekitar kampus.", imageUrl = "ic_facebook_black_24dp.png"),
            DailyActivity(title = "Ngopi", time = "20:00 - 21:30", description = "Menyelami dunia fiksi ilmiah sebelum tidur.", imageUrl = "ic_facebook_black_24dp.png"),
            DailyActivity(title = "Baca Komik dan Bermain Game", time = "21:00 - 23:30", description = "Mengevaluasi hari dan membuat rencana esok.", imageUrl = "ic_facebook_black_24dp.png")
        )
    }

    fun getFriends(): List<Friend> {
        return listOf(
            Friend(name = "Farkhan", photoUrl = "friend_andi"),
            Friend(name = "Daniel", photoUrl = "friend_budi"),
            Friend(name = "Aksal", photoUrl = "friend_citra"),
            Friend(name = "Andrian", photoUrl = "friend_dewi"),
            Friend(name = "Alka", photoUrl = "friend_eko"),
            Friend(name = "Fathan", photoUrl = "friend_fara")
        )
    }

    fun getGalleryItems(): List<GalleryItem> {
        return listOf(
            GalleryItem(imageUrl = "gallery_1", description = "Langit Malam Berbintang"),
            GalleryItem(imageUrl = "gallery_2", description = "Sungai di Pegunungan"),
            GalleryItem(imageUrl = "gallery_3", description = "Hutan Fantasi"),
            GalleryItem(imageUrl = "gallery_4", description = "Abstrak Warna-warni"),
            GalleryItem(imageUrl = "gallery_5", description = "Puncak Gunung Bersalju"),
            GalleryItem(imageUrl = "gallery_6", description = "Danau yang Tenang"),
            GalleryItem(imageUrl = "gallery_7", description = "Langit Malam Berbintang (2)"),
        )
    }

    fun getMusicItems(): List<MusicItem> {
        return listOf(
            MusicItem(title = "Nectar", artist = "Joji", thumbnailUrl = "music_1"),
            MusicItem(title = "This is Home", artist = "Cavetown", thumbnailUrl = "music_2"),
            MusicItem(title = "Cigarettes After Sex", artist = "Cigarettes After Sex", thumbnailUrl = "music_3")
        )
    }

    fun getVideoItems(): List<VideoItem> {
        return listOf(
            VideoItem(title = "Introduction to Android Development", thumbnailUrl = "video_1", videoUrl = "https://www.youtube.com/watch?v=KusHOIl8BaU&list=RDMMKusHOIl8BaU&start_radio=1"), // <--- GANTI THUMBNAIL
            VideoItem(title = "The Beauty of Indonesian Nature", thumbnailUrl = "video_2", videoUrl = "https://www.youtube.com/watch?v=KusHOIl8BaU&list=RDMMKusHOIl8BaU&start_radio=1"), // <--- GANTI THUMBNAIL
            VideoItem(title = "Cooking Vlog: Indonesian Street Food", thumbnailUrl = "video_3", videoUrl = "https://www.youtube.com/watch?v=KusHOIl8BaU&list=RDMMKusHOIl8BaU&start_radio=1") // <--- GANTI THUMBNAIL
        )
    }

    fun getWalkthroughPages(): List<WalkthroughPage> {
        return listOf(
            WalkthroughPage(imageResId = R.drawable.ic_onboarding_welcome, title = "Jelajahi Duniaku.", description = "Ini adalah ruang personal tempat kamu bisa melihat lebih dekat siapa diriku, apa yang aku suka, dan aktivitas harianku."),
            WalkthroughPage(imageResId = R.drawable.ic_onboarding_activity, title = "Kegiatan & Passion dalam Genggaman.", description = "Lihat rutinitas harianku, daftar hobi, minat unik, hingga cita-cita yang menginspirasi."),
            WalkthroughPage(imageResId = R.drawable.ic_onboarding_connect, title = "Terhubung Lebih Dekat.", description = "Mudah untuk menghubungiku atau menemukan lokasiku di peta, dan intip momen spesialku di galeri.")
        )
    }
}