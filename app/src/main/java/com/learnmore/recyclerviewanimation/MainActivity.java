package com.learnmore.recyclerviewanimation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 1", "Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Line 3", "Line 4"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 5", "Line 6"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Line 7", "Line 8"));


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList, this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        String s = getIntent().getStringExtra("input");
        if (s != null) {
            if (s.equals("2")) {
                runLayoutAnimationFallDown();
            }
        }

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            Intent intent = new Intent(MainActivity.this, DetailedActivity.class);

            @Override
            public void onItemClick(int position) {
                if (position == 0) {
                    intent.putExtra("position", "0");
                    startActivity(intent);
                } else if (position == 1) {
                    intent.putExtra("position", "1");
                    startActivity(intent);
                } else if (position == 2) {
                    intent.putExtra("position", "2");
                    startActivity(intent);
                } else if (position == 3) {
                    intent.putExtra("position", "3");
                    startActivity(intent);
                }
            }
        });

    }


    public RecyclerView getmRecyclerView() {
        return this.mRecyclerView;
    }

    private void runLayoutAnimationFallDown() {

        Context context = mRecyclerView.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        mRecyclerView.setLayoutAnimation(layoutAnimationController);
        mRecyclerView.getAdapter().notifyDataSetChanged();
        mRecyclerView.scheduleLayoutAnimation();
    }

   /* void runLayoutAnimationFromBottom(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_bottom);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }*/


}
