package com.example.android_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String name=getIntent().getStringExtra("Name");
        String uni=getIntent().getStringExtra("University");
        int image=getIntent().getIntExtra("Image",0);

        TextView nameText= findViewById(R.id.txt1);
        TextView university=findViewById(R.id.txt2);
        ImageView image1=findViewById(R.id.img1);

        nameText.setText(name);
        university.setText(uni);
        image1.setImageResource(image);

    }
}