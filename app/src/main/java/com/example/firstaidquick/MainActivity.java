package com.example.firstaidquick;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {
    ImageButton btnBurn, btnHeat, btnFever, btnFracture, btnChoke, btnPoison, btnScrape, btnStroke, btnSOS;
    FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button symptomBtn = findViewById(R.id.symptomButton);
        symptomBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, SymptomCheckerActivity.class);
            startActivity(intent);
        });



        // Existing buttons
        btnBurn = findViewById(R.id.btnBurn);
        btnHeat = findViewById(R.id.ivHeat);
        btnFever = findViewById(R.id.btnFever);
        btnFracture = findViewById(R.id.btnFracture);
        btnChoke = findViewById(R.id.btnChoke);
        btnPoison = findViewById(R.id.btnPoison);
        btnScrape = findViewById(R.id.btnScrape);
        btnStroke = findViewById(R.id.btnStroke);
        btnSOS = findViewById(R.id.btnSOS); // 🚨 SOS Button

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        btnBurn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, BurnActivity.class)));
        btnHeat.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HeatActivity.class)));
        btnFever.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FeverActivity.class)));
        btnFracture.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FractureActivity.class)));
        btnChoke.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ChokeActivity.class)));
        btnPoison.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PoisonActivity.class)));
        btnScrape.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ScrapeActivity.class)));
        btnStroke.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, StrokeActivity.class)));

        // 🚨 SOS Button logic
        btnSOS.setOnClickListener(v -> {

            // 🔊 Play alarm sound (alarm.mp3 must be in res/raw/)
            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.alarm);
            mp.setLooping(false);
            mp.start();

            // ✅ Check permissions
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.CALL_PHONE
                }, 1);
                return;
            }

            // 📍 Get location and send SMS
            fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
                if (location != null) {
                    String lat = String.valueOf(location.getLatitude());
                    String lon = String.valueOf(location.getLongitude());
                    String message = "🚨 Emergency! I need help. My location: https://maps.google.com/?q=" + lat + "," + lon;

                    String emergencyContact = "+639948225007"; // 🔁 Replace this with actual emergency contact
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(emergencyContact, null, message, null, null);

                    Toast.makeText(MainActivity.this, "Emergency message sent!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to get location.", Toast.LENGTH_SHORT).show();
                }
            });

            // 📞 Call 911
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:911")); // 🔁 Change number if needed
            startActivity(callIntent);
        });
    }
}
