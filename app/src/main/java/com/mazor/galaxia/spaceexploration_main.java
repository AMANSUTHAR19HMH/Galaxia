package com.mazor.galaxia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class spaceexploration_main extends AppCompatActivity {
    ImageButton mars, earth, neptune, jupiter, uranus, mercury, saturn, venus;
    TextView mercurybtn;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spaceexploration_main);
        // Initialize buttons
        layout = findViewById(R.id.marslayout);
        mercurybtn = findViewById(R.id.mercurry);
        mars = findViewById(R.id.mars);
        earth = findViewById(R.id.earth);
        jupiter = findViewById(R.id.jupiter);
        venus = findViewById(R.id.venus);
        saturn = findViewById(R.id.saturn);
        mercury = findViewById(R.id.mercury);
        uranus = findViewById(R.id.uranus);
        neptune = findViewById(R.id.naptune); // Fixed spelling

        mercurybtn.setOnClickListener(v -> openActivity(semars.class));
        // Set Click Listeners
        mars.setOnClickListener(v -> openActivity(semars.class));
        earth.setOnClickListener(v -> openActivity(seearth.class));
        jupiter.setOnClickListener(v -> openActivity(sejupyter.class));
        venus.setOnClickListener(v -> openActivity(sevenus.class));
        saturn.setOnClickListener(v -> openActivity(sesaturn.class));
        uranus.setOnClickListener(v -> openActivity(seuranus.class));
//        mercury.setOnClickListener(v -> openActivity(semercury.class)); // Added Mercury
        neptune.setOnClickListener(v -> openActivity(seneptune.class)); // Added Neptune
    }

    // Helper function to start activity
    private void openActivity(Class<?> targetActivity) {
        Intent intent = new Intent(spaceexploration_main.this, targetActivity);
        startActivity(intent);
    }
}
