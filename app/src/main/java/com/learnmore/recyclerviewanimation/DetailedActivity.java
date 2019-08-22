package com.learnmore.recyclerviewanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailedActivity.this, MainActivity.class);
        intent.putExtra("input", "2");
        startActivity(intent);
    }
}
