package com.example.firstaidquick;

import android.net.Uri;
import android.widget.VideoView;
import android.widget.MediaController;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HeatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heat);

        // 🎥 Video Setup
        VideoView videoView = findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.heat;
        videoView.setVideoURI(Uri.parse(path));

// Optional: playback controls
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

// Start the video
        videoView.start();


        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        TextView dpGeneral = findViewById(R.id.dpGeneral);
        LinearLayout dpContent1 = findViewById(R.id.dpContent1);
        LinearLayout parent1 = findViewById(R.id.parent1);

        dpGeneral.setOnClickListener(v -> {
            if (dpContent1.getVisibility() == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(parent1, new AutoTransition());
                dpContent1.setVisibility(View.GONE);
                dpGeneral.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down, 0);
            } else {
                TransitionManager.beginDelayedTransition(parent1, new AutoTransition());
                dpContent1.setVisibility(View.VISIBLE);
                dpGeneral.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_up, 0);
            }
        });
    }
}
