package com.example.firstaidquick;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SymptomCheckerActivity extends AppCompatActivity {

    EditText symptomInput;
    Button checkButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_checker);

        symptomInput = findViewById(R.id.symptomInput);
        checkButton = findViewById(R.id.checkButton);
        resultText = findViewById(R.id.resultText);

        checkButton.setOnClickListener(view -> {
            String input = symptomInput.getText().toString().toLowerCase();
            String result = getSymptomAnalysis(input);
            resultText.setText(result);
        });
    }

    // 🔍 Enhanced keyword-based symptom checker
    private String getSymptomAnalysis(String symptoms) {
        if (symptoms.contains("chest pain") || symptoms.contains("shortness of breath")) {
            return "🫀 Possible: Heart Attack\n💡 First Aid: Call emergency hotline immediately and keep the person calm.";
        } else if (symptoms.contains("fever") && symptoms.contains("cough")) {
            return "🤒 Possible: Flu or COVID-19\n💡 First Aid: Isolate, hydrate, and seek medical attention if symptoms worsen.";
        } else if (symptoms.contains("headache") && symptoms.contains("nausea")) {
            return "🤕 Possible: Migraine or Dehydration\n💡 First Aid: Rest in a dark room and drink fluids.";
        } else if (symptoms.contains("dizziness") || symptoms.contains("weakness")) {
            return "🧠 Possible: Low blood sugar or Stroke\n💡 First Aid: Sit down, check blood sugar, or call for help if one side of the body is weak.";
        } else if (symptoms.contains("choking") || symptoms.contains("can't breathe") || symptoms.contains("airway blocked")) {
            return "😮 Possible: Choking\n💡 First Aid: Perform abdominal thrusts (Heimlich maneuver) and call emergency services if needed.";
        } else if (symptoms.contains("rash") || symptoms.contains("itchy") || symptoms.contains("swelling")) {
            return "🌼 Possible: Allergic Reaction\n💡 First Aid: Avoid allergen, give antihistamine, and use epinephrine if severe.";
        } else if (symptoms.contains("burn") || symptoms.contains("blister") || symptoms.contains("skin red")) {
            return "🔥 Possible: Burn Injury\n💡 First Aid: Run cool (not cold) water over the burn for 10 minutes, cover with sterile dressing.";
        } else if (symptoms.contains("bleeding") || symptoms.contains("cut") || symptoms.contains("blood")) {
            return "🩸 Possible: Severe Bleeding\n💡 First Aid: Apply firm pressure with a clean cloth, elevate limb, seek medical attention.";
        } else if (symptoms.contains("fracture") || symptoms.contains("broken bone") || symptoms.contains("can't move limb")) {
            return "🦴 Possible: Fracture\n💡 First Aid: Immobilize the limb, avoid movement, and go to the hospital.";
        } else {
            return "❓ Sorry, I couldn't recognize those symptoms.\n💡 Try using simple terms or consult a healthcare provider.";
        }
    }
}
