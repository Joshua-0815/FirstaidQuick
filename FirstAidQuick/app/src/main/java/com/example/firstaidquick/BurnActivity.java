package com.example.firstaidquick;

import android.net.Uri;
import android.widget.VideoView;
import android.widget.MediaController;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.transition.AutoTransition;

import androidx.appcompat.app.AppCompatActivity;


public class BurnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burn);

        // 🎥 Video Setup
        VideoView videoView = findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.burn;
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

        TextView dpChemical = findViewById(R.id.dpChemical);
        LinearLayout dpContent2 = findViewById(R.id.dpContent2);
        LinearLayout parent2 = findViewById(R.id.parent2);

        dpChemical.setOnClickListener(v -> {
            if (dpContent2.getVisibility() == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(parent2, new AutoTransition());
                dpContent2.setVisibility(View.GONE);
                dpChemical.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down, 0);
            } else {
                TransitionManager.beginDelayedTransition(parent2, new AutoTransition());
                dpContent2.setVisibility(View.VISIBLE);
                dpChemical.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_up, 0);
            }
        });

        TextView dpElectrical = findViewById(R.id.dpElectrical);
        LinearLayout dpContent3 = findViewById(R.id.dpContent3);
        LinearLayout parent3 = findViewById(R.id.parent3);

        dpElectrical.setOnClickListener(v -> {
            if (dpContent3.getVisibility() == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(parent3, new AutoTransition());
                dpContent3.setVisibility(View.GONE);
                dpElectrical.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down, 0);
            } else {
                TransitionManager.beginDelayedTransition(parent3, new AutoTransition());
                dpContent3.setVisibility(View.VISIBLE);
                dpElectrical.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_up, 0);
            }
        });

        TextView dpThermal = findViewById(R.id.dpThermal);
        LinearLayout dpContent4 = findViewById(R.id.dpContent4);
        LinearLayout parent4 = findViewById(R.id.parent4);

        dpThermal.setOnClickListener(v -> {
            if (dpContent4.getVisibility() == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(parent4, new AutoTransition());
                dpContent4.setVisibility(View.GONE);
                dpThermal.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down, 0);
            } else {
                TransitionManager.beginDelayedTransition(parent4, new AutoTransition());
                dpContent4.setVisibility(View.VISIBLE);
                dpThermal.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_up, 0);
            }
        });
    }
}
