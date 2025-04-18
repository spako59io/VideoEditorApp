package com.videoeditor

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class MainActivity : AppCompatActivity() {
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialise le player
        player = ExoPlayer.Builder(this).build()
        val playerView = findViewById<StyledPlayerView>(R.id.player_view)
        playerView.player = player
        
        // Charge une vidéo (à remplacer par votre logique de sélection)
        val videoUri = Uri.parse("asset:///sample.mp4") // Exemple
        val mediaItem = MediaItem.fromUri(videoUri)
        player?.setMediaItem(mediaItem)
        player?.prepare()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }
}