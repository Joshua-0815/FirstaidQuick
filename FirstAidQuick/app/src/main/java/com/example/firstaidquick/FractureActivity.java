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
import android.text.Html;


import androidx.appcompat.app.AppCompatActivity;

public class FractureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fracture);

        // 🎥 Video Setup
        VideoView videoView = findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.fracture;
        videoView.setVideoURI(Uri.parse(path));

// Optional: playback controls
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

// Start the video
        videoView.start();


        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        TextView tv4 = findViewById(R.id.tv4);
        String html = "A <b>sprain</b> occurs when a ligament is stretched, torn or damaged. Ligaments connect bones to bones at the joints. Sprains most commonly affect the ankle, knee, wrist and finger joints.";
        tv4.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));

        TextView tv5 = findViewById(R.id.tv5);
        String html1 = "A <b>strain</b> occurs when a tendon or muscle is stretched, torn or damaged. Tendons connect muscles to bones. Strains often are caused by lifting something heavy or working a muscle too hard. They usually involve the muscles in the neck, back, thigh or the back of the lower leg. Some strains can reoccur, especially in the neck and back.";
        tv5.setText(Html.fromHtml(html1, Html.FROM_HTML_MODE_LEGACY));

        TextView tv6 = findViewById(R.id.tv6);
        String html2 = "A <b>dislocation</b> occurs when the bones that meet at a joint move out of their normal position. This type of injury is usually caused by a violent force that tears the ligaments, allowing the bones to move out of place.";
        tv6.setText(Html.fromHtml(html2, Html.FROM_HTML_MODE_LEGACY));

        TextView tv7 = findViewById(R.id.tv7);
        String html3 = "A <b>fracture</b> is a complete break, a chip or a crack in a bone. Fractures can be open (the end of the broken bone breaks through the skin) or closed (the broken bone does not break through the skin).";
        tv7.setText(Html.fromHtml(html3, Html.FROM_HTML_MODE_LEGACY));

        TextView tv13 = findViewById(R.id.tv13);
        String html4 = "Unable or unwilling to move injured area *";
        tv13.setText(Html.fromHtml(html4, Html.FROM_HTML_MODE_LEGACY));

        TextView tv14 = findViewById(R.id.tv14);
        String html5 = "Bent, crooked or deformed injured area *";
        tv14.setText(Html.fromHtml(html5, Html.FROM_HTML_MODE_LEGACY));

        TextView tv15 = findViewById(R.id.tv15);
        String html6 = "“Popping” or “snapping” at a time of injury *";
        tv15.setText(Html.fromHtml(html6, Html.FROM_HTML_MODE_LEGACY));

        TextView tv16 = findViewById(R.id.tv16);
        String html7 = "“Grating” when trying to move injured area *";
        tv16.setText(Html.fromHtml(html7, Html.FROM_HTML_MODE_LEGACY));

        TextView tv17 = findViewById(R.id.tv17);
        String html8 = "Coldness, numbness, tingling at or below injured area *";
        tv17.setText(Html.fromHtml(html8, Html.FROM_HTML_MODE_LEGACY));

        TextView tv18 = findViewById(R.id.tv18);
        String html9 = "Bleeding or bone protruding through skin *";
        tv18.setText(Html.fromHtml(html9, Html.FROM_HTML_MODE_LEGACY));

        TextView tv19 = findViewById(R.id.tv19);
        String html10 = "Injury to head, neck, spine, pelvis or upper leg *";
        tv19.setText(Html.fromHtml(html10, Html.FROM_HTML_MODE_LEGACY));

        TextView tv20 = findViewById(R.id.tv20);
        String html11 = "Severe or multiple injuries *";
        tv20.setText(Html.fromHtml(html11, Html.FROM_HTML_MODE_LEGACY));

        TextView tv21 = findViewById(R.id.tv21);
        String html12 = "Significant cause of injury *";
        tv21.setText(Html.fromHtml(html12, Html.FROM_HTML_MODE_LEGACY));

        TextView tv22 = findViewById(R.id.tv22);
        String html13 = "Unable to safely move them *";
        tv22.setText(Html.fromHtml(html13, Html.FROM_HTML_MODE_LEGACY));

        TextView tv23 = findViewById(R.id.tv23);
        String html14 = "Signs and symptoms of shock *";
        tv23.setText(Html.fromHtml(html14, Html.FROM_HTML_MODE_LEGACY));

        TextView tv24 = findViewById(R.id.tv24);
        String html15 = "Pain, swelling & bruising";
        tv24.setText(Html.fromHtml(html15, Html.FROM_HTML_MODE_LEGACY));

        TextView tv25 = findViewById(R.id.tv25);
        String html16 = "Signs of broken rib(s):";
        tv25.setText(Html.fromHtml(html16, Html.FROM_HTML_MODE_LEGACY));

        TextView tv26 = findViewById(R.id.tv26);
        String html17 = "Small, shallow, uncomfortable, or painful breaths";
        tv26.setText(Html.fromHtml(html17, Html.FROM_HTML_MODE_LEGACY));

        TextView tv27 = findViewById(R.id.tv27);
        String html18 = "Support of injured area";
        tv27.setText(Html.fromHtml(html18, Html.FROM_HTML_MODE_LEGACY));

        TextView tv28 = findViewById(R.id.tv28);
        String html19 = "Note: Signs and symptoms with a * require immediate emergency medical treatment.";
        tv28.setText(Html.fromHtml(html19, Html.FROM_HTML_MODE_LEGACY));

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

        TextView dpRib = findViewById(R.id.dpRib);
        LinearLayout dpContent2 = findViewById(R.id.dpContent2);
        LinearLayout parent2 = findViewById(R.id.parent2);

        dpRib.setOnClickListener(v -> {
            if (dpContent2.getVisibility() == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(parent2, new AutoTransition());
                dpContent2.setVisibility(View.GONE);
                dpRib.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down, 0);
            } else {
                TransitionManager.beginDelayedTransition(parent2, new AutoTransition());
                dpContent2.setVisibility(View.VISIBLE);
                dpRib.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_up, 0);
            }
        });

    }
}
