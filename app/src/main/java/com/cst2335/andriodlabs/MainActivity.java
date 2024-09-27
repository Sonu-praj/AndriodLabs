package com.cst2335.andriodlabs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable edge-to-edge display
        EdgeToEdge.enable(this);

        // Set the content view to your layout (adjust if necessary)
        setContentView(R.layout.activity_main);

        // Adjust padding to accommodate system bars (status bar, nav bar, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the Button in the layout and set up a click listener (Step 4)
        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            // Show a toast when the button is clicked
            Toast.makeText(MainActivity.this, getString(R.string.toast_message), Toast.LENGTH_LONG).show();
        });

        // Find the Switch in the layout and set up a listener for its state change (Step 5)
        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            // Show a Snackbar when the switch is toggled
            Snackbar snackbar = Snackbar.make(compoundButton, "The switch is now " + (isChecked ? "ON" : "OFF"), Snackbar.LENGTH_LONG);
            // Add an "Undo" action to the Snackbar
            snackbar.setAction("Undo", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toggle the switch back to the previous state when "Undo" is clicked
                    switch1.setChecked(!isChecked);
                }
            });
            snackbar.show();
        });
    }
}
