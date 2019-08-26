package com.learnmore.recyclerviewanimation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class DetailedActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Toolbar toolbar = findViewById(R.id.toolbarDetailed);
        setSupportActionBar(toolbar);

        imageView = findViewById(R.id.toolbarImage);
        String position = getIntent().getStringExtra("position");


        if (position.equals("0")) {
            toolbar.setBackgroundColor(Color.parseColor("#567845"));
            getSupportActionBar().setTitle("My Title 1");
        } else if (position.equals("1")) {
            getSupportActionBar().setTitle("My Title 2");
            toolbar.setBackgroundColor(Color.parseColor("#39FF33"));
        } else if (position.equals("2")) {
            getSupportActionBar().setTitle("My Title 3");
            toolbar.setBackgroundColor(Color.parseColor("#4633FF"));
        } else if (position.equals("3")) {
            getSupportActionBar().setTitle("My Title 4");
            toolbar.setBackgroundColor(Color.parseColor("#AF33FF"));
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailedActivity.this, MainActivity.class);
                intent.putExtra("input", "2");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailedActivity.this, MainActivity.class);
        intent.putExtra("input", "2");
        startActivity(intent);
    }
}
