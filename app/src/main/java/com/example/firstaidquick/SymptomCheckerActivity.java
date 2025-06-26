package com.example.firstaidquick;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SymptomCheckerActivity extends AppCompatActivity {

    EditText symptomInput;
    Button checkButton;
    TextView resultText;
    PieChart pieChart;
    BarChart barChart;

    // History of matched conditions
    Map<String, Integer> conditionHistory = new HashMap<String, Integer>() {{
        put("Heart", 0);
        put("Flu", 0);
        put("Migraine", 0);
        put("Stroke", 0);
        put("Choking", 0);
        put("Allergy", 0);
        put("Burn", 0);
        put("Bleeding", 0);
        put("Fracture", 0);
        put("Unrecognized", 0);
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_checker);

        symptomInput = findViewById(R.id.symptomInput);
        checkButton = findViewById(R.id.checkButton);
        resultText = findViewById(R.id.resultText);
        pieChart = findViewById(R.id.pieChart);
        barChart = findViewById(R.id.barChart);

        checkButton.setOnClickListener(view -> {
            String input = symptomInput.getText().toString().toLowerCase();
            String[] analysis = getSymptomAnalysis(input);
            String result = analysis[0];
            String category = analysis[1];

            resultText.setText(result);

            if (conditionHistory.containsKey(category)) {
                conditionHistory.put(category, conditionHistory.get(category) + 1);
            }

            updatePieChart(category);
            updateBarChart();
        });
    }

    private void updatePieChart(String matchedCategory) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(1f, matchedCategory));

        PieDataSet dataSet = new PieDataSet(entries, "Current Match");
        dataSet.setColors(Color.rgb(155, 89, 182)); // Purple
        dataSet.setValueTextSize(14f);
        dataSet.setValueTextColor(Color.WHITE);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.setUsePercentValues(true);

        Description desc = new Description();
        desc.setText("This Symptom Match");
        pieChart.setDescription(desc);

        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setEntryLabelTextSize(14f);
        pieChart.animateY(800);
        pieChart.invalidate();
    }

    private void updateBarChart() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<>();
        int index = 0;

        for (Map.Entry<String, Integer> entry : conditionHistory.entrySet()) {
            entries.add(new BarEntry(index, entry.getValue()));
            labels.add(entry.getKey());
            index++;
        }

        BarDataSet barDataSet = new BarDataSet(entries, "Total Diagnoses");
        barDataSet.setColors(Color.rgb(231, 76, 60), Color.rgb(52, 152, 219), Color.rgb(46, 204, 113),
                Color.rgb(241, 196, 15), Color.rgb(155, 89, 182), Color.rgb(230, 126, 34),
                Color.rgb(149, 165, 166), Color.rgb(44, 62, 80), Color.rgb(127, 140, 141), Color.DKGRAY);
        barDataSet.setValueTextSize(12f);
        barDataSet.setValueTextColor(Color.BLACK);

        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.9f);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setLabelRotationAngle(45);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(12f);

        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.getAxisLeft().setTextSize(12f);
        barChart.getAxisRight().setEnabled(false);

        Description desc = new Description();
        desc.setText("History of Diagnoses");
        barChart.setDescription(desc);

        barChart.animateY(1000);
        barChart.invalidate();
    }

    // Returns [message, category]
    private String[] getSymptomAnalysis(String symptoms) {
        if (symptoms.contains("chest pain") || symptoms.contains("shortness of breath")) {
            return new String[]{
                    "🫀 Possible: Heart Attack\n💡 First Aid: Call emergency hotline immediately and keep the person calm.",
                    "Heart"
            };
        } else if (symptoms.contains("fever") && symptoms.contains("cough")) {
            return new String[]{
                    "🤒 Possible: Flu or COVID-19\n💡 First Aid: Isolate, hydrate, and seek medical attention if symptoms worsen.",
                    "Flu"
            };
        } else if (symptoms.contains("headache") && symptoms.contains("nausea")) {
            return new String[]{
                    "🤕 Possible: Migraine or Dehydration\n💡 First Aid: Rest in a dark room and drink fluids.",
                    "Migraine"
            };
        } else if (symptoms.contains("dizziness") || symptoms.contains("weakness")) {
            return new String[]{
                    "🧠 Possible: Low blood sugar or Stroke\n💡 First Aid: Sit down, check blood sugar, or call for help if one side of the body is weak.",
                    "Stroke"
            };
        } else if (symptoms.contains("choking") || symptoms.contains("can't breathe") || symptoms.contains("airway blocked")) {
            return new String[]{
                    "😮 Possible: Choking\n💡 First Aid: Perform abdominal thrusts (Heimlich maneuver) and call emergency services if needed.",
                    "Choking"
            };
        } else if (symptoms.contains("rash") || symptoms.contains("itchy") || symptoms.contains("swelling")) {
            return new String[]{
                    "🌼 Possible: Allergic Reaction\n💡 First Aid: Avoid allergen, give antihistamine, and use epinephrine if severe.",
                    "Allergy"
            };
        } else if (symptoms.contains("burn") || symptoms.contains("blister") || symptoms.contains("skin red")) {
            return new String[]{
                    "🔥 Possible: Burn Injury\n💡 First Aid: Run cool (not cold) water over the burn for 10 minutes, cover with sterile dressing.",
                    "Burn"
            };
        } else if (symptoms.contains("bleeding") || symptoms.contains("cut") || symptoms.contains("blood")) {
            return new String[]{
                    "🩸 Possible: Severe Bleeding\n💡 First Aid: Apply firm pressure with a clean cloth, elevate limb, seek medical attention.",
                    "Bleeding"
            };
        } else if (symptoms.contains("fracture") || symptoms.contains("broken bone") || symptoms.contains("can't move limb")) {
            return new String[]{
                    "🦴 Possible: Fracture\n💡 First Aid: Immobilize the limb, avoid movement, and go to the hospital.",
                    "Fracture"
            };
        } else {
            return new String[]{
                    "❓ Sorry, I couldn't recognize those symptoms.\n💡 Try using simple terms or consult a healthcare provider.",
                    "Unrecognized"
            };
        }
    }
}
