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
            description = "Seorang mahasiswa aktif di salah satu universitas di Bandung, dengan ketertarikan mendalam pada pengembangan aplikasi mobile, khususnya Android. Saya suka belajar hal baru, berkolaborasi dalam proyek tim, dan memecahkan masalah kompleks. Di waktu luang, saya menikmati bermain game, membaca komik, dan menonton anime. Cita-cita saya adalah menjadi seorang pengusaha serta ingin menjadi orang yang bisa membawa dampak positif bagi banyak orang",
            profession = "Mahasiswa Informatika | Android Developer",
            quote = "“If I don’t have to do it, I won’t. If I have to do it, I’ll make it quick.”"
        )
    }

    fun getDailyActivities(): List<DailyActivity> {
        return listOf(
            DailyActivity(title = "Kelas Pagi", time = "07:00 - 09:00", description = "Mengikuti mata kuliah Pemrograman Android.", imageUrl = "ic_shool_black"),
            DailyActivity(title = "Latihan Coding Mandiri", time = "11:30 - 13:00", description = "Mengerjakan studi kasus Android.", imageUrl = "ic_shool_black"),
            DailyActivity(title = "Makan Siang", time = "13:00 - 14:00", description = "Istirahat sambil menikmati makanan .", imageUrl = "ic_shool_black"),
            DailyActivity(title = "Diskusi Kelompok Tugas Besar", time = "14:00 - 16:00", description = "Merencanakan arsitektur proyek bersama tim.", imageUrl = "ic_activity_placeholder"),
            DailyActivity(title = "Refreshing", time = "16:00 - 18:00", description = "Nyoride", imageUrl = "ic_activity_placeholder"),
            DailyActivity(title = "Ngopi", time = "20:00 - 21:30", description = "Ngopi Bareng Teman.", imageUrl = "ic_activity_placeholder"),
            DailyActivity(title = "Baca Komik dan Bermain Game", time = "21:00 - 23:30", description = "Membaca Komik dan Bermain game sebelum tidur", imageUrl = "ic_activity_placeholder")
        )
    }

    fun getInterests(): List<Interest> {
        return listOf(
            Interest(type = "hoby", item = "Bermain Game"),
            Interest(type = "hoby", item = "Membaca Komik"),

            Interest(type = "suka", item = "Musik"),

            Interest(type = "tidak_suka", item = "Saldo kosong"),

            Interest(type = "minat", item = "Ngoding"),

            Interest(type = "cita_cita", item = "Pengusaha"),
        )
    }

    fun getFriends(): List<Friend> {
        return listOf(
            Friend(name = "Farkhan", photoUrl = "friend_farkhan"),
            Friend(name = "Daniel", photoUrl = "friend_daniel"),
            Friend(name = "Aksal", photoUrl = "friend_aksal"),
            Friend(name = "Andrian", photoUrl = "friend_andrian"),
            Friend(name = "Alka", photoUrl = "friend_alka"),
            Friend(name = "Fathan", photoUrl = "friend_fathan")
        )
    }

    fun getGalleryItems(): List<GalleryItem> {
        return listOf(
            GalleryItem(imageUrl = "gallery_1"),
            GalleryItem(imageUrl = "gallery_6"),
            GalleryItem(imageUrl = "gallery_4"),
            GalleryItem(imageUrl = "gallery_5"),
            GalleryItem(imageUrl = "gallery_2"),
            GalleryItem(imageUrl = "gallery_3"),
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
            VideoItem(title = "The Beginning After The End", thumbnailUrl = "video_1", videoUrl = "https://anime.oploverz.ac/the-beginning-after-the-end-episode-10-subtitle-indonesia/"),
            VideoItem(title = "Wind Breaker S2", thumbnailUrl = "video_2", videoUrl = "https://anime.oploverz.ac/wind-breaker-s2-episode-10-subtitle-indonesia/"),
            VideoItem(title = "One Piece", thumbnailUrl = "video_3", videoUrl = "https://anime.oploverz.ac/one-piece-episode-1132-subtitle-indonesia/")
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