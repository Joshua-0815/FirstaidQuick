package com.example.firstaidquick;

import android.net.Uri;
import android.widget.VideoView;
import android.widget.MediaController;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PoisonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poison);

        // 🎥 Video Setup
        VideoView videoView = findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.poison;
        videoView.setVideoURI(Uri.parse(path));

// Optional: playback controls
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

// Start the video
        videoView.start();

    }
}
