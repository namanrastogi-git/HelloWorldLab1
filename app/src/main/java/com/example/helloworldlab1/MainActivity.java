package com.example.helloworldlab1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Window inset handling
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // References to TextView and Buttons
        TextView tvMessage = findViewById(R.id.textView2);
        Button btnChangeText = findViewById(R.id.button);
        Button btnChangeColor = findViewById(R.id.button2);

        // Change text on first button click
        btnChangeText.setOnClickListener(v -> tvMessage.setText("Button was clicked!"));

        // Change text color on second button click
        btnChangeColor.setOnClickListener(v -> {
            int color = Color.rgb(
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256)
            );
            tvMessage.setTextColor(color);
        });
    }
}
