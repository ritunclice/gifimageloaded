package com.example.gifimage;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;


public class MainActivity extends AppCompatActivity {

    GifImageView gifImageView;

    @SuppressLint("VisibleForTests")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


         gifImageView = findViewById(R.id.gifImageView);

        try {
            // Load the GIF image
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.your_gif_resource); // Replace "your_gif_resource" with your GIF resource
            gifImageView.setImageDrawable(gifDrawable);

            // Stop the GIF animation after it's loaded
            gifDrawable.setLoopCount(1); // Set the loop count to 1 to play only once
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}